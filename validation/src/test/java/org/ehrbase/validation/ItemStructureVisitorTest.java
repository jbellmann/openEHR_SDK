/*
 * Copyright (c) 2019 Vitasystems GmbH and Christian Chevalley (Hannover Medical School).
 *
 * This file is part of project EHRbase
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehrbase.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nedap.archie.json.ArchieJacksonConfiguration;
import com.nedap.archie.json.JacksonUtil;

import com.nedap.archie.rm.composition.Composition;
import com.nedap.archie.rm.datastructures.ItemTree;
import com.nedap.archie.rm.datavalues.DvText;
import com.nedap.archie.rm.ehr.EhrStatus;
import com.nedap.archie.rm.generic.PartySelf;
import com.nedap.archie.rm.support.identification.PartyRef;
import com.nedap.archie.xml.JAXBUtil;
import org.apache.commons.io.IOUtils;
import org.ehrbase.terminology.openehr.implementation.AttributeCodesetMapping;
import org.ehrbase.terminology.openehr.implementation.LocalizedTerminologies;
import org.ehrbase.test_data.composition.CompositionTestDataCanonicalXML;
import org.ehrbase.test_data.item_structure.ItemStruktureTestDataCanonicalJson;
import org.ehrbase.validation.terminology.ItemStructureVisitor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ItemStructureVisitorTest {

    private LocalizedTerminologies localizedTerminologies;
    private AttributeCodesetMapping codesetMapping;
    private ItemStructureVisitor itemStructureVisitor;

    @Before
    public void setup() throws Exception {
        localizedTerminologies = new LocalizedTerminologies();
        codesetMapping = AttributeCodesetMapping.getInstance();
        itemStructureVisitor = new ItemStructureVisitor(localizedTerminologies);
    }


    @Test
    public void elementVisitorTest() throws Throwable {
        Unmarshaller unmarshaller = JAXBUtil.createRMContext().createUnmarshaller();
        Composition composition = (Composition) unmarshaller.unmarshal(new FileInputStream(new File("./src/test/resources/composition/test_all_types.fixed.v1.xml")));


        itemStructureVisitor.validate(composition);
        assertEquals(26, itemStructureVisitor.getElementOccurrences()); //25 ELEMENTs + 1 ITEM_SINGLE!

    }

    @Test
    public void elementVisitorTestNor() throws Throwable {
        Unmarshaller unmarshaller = JAXBUtil.createRMContext().createUnmarshaller();
        Composition composition = (Composition) unmarshaller.unmarshal(new FileInputStream(new File("./src/test/resources/composition/IDCR-LabReportRAW1_with_normal_status.xml")));

        try {
            itemStructureVisitor.validate(composition);
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void elementVisitorTest2() throws Throwable {
        Unmarshaller unmarshaller = JAXBUtil.createRMContext().createUnmarshaller();
        Composition composition = (Composition) unmarshaller.unmarshal(new FileInputStream(new File("./src/test/resources/composition/RIPPLE-ConformanceTest.xml")));

        itemStructureVisitor.validate(composition);
        assertEquals(61, itemStructureVisitor.getElementOccurrences()); //4 elements are in the context/other_context structure

        itemStructureVisitor.validate(composition.getContext().getOtherContext());
        assertEquals(65, itemStructureVisitor.getElementOccurrences());

    }
    @Test
    public void elementVisitorTest3() throws Throwable {
        Unmarshaller unmarshaller = JAXBUtil.createRMContext().createUnmarshaller();
        Composition composition = (Composition) unmarshaller.unmarshal(new FileInputStream(new File("./src/test/resources/composition/RIPPLE-ConformanceTest_invalid_other_context_mm_type.xml")));

        try {
            itemStructureVisitor.validate(composition);
        } catch (IllegalArgumentException e){
            assertTrue(e.getMessage().contains("supplied code string [video/mp4] is not found in codeset:media types"));
        }

    }


    @Test
    public void ehrVisitorTest() throws Throwable {
        String value = IOUtils.toString(ItemStruktureTestDataCanonicalJson.SIMPLE_EHR_OTHER_Details.getStream(), UTF_8);

        ArchieJacksonConfiguration configuration = ArchieJacksonConfiguration.createStandardsCompliant();
        configuration.setTypePropertyName("_type");
        ObjectMapper objectMapper = JacksonUtil.getObjectMapper(configuration);

        ItemTree otherDetails = objectMapper.readValue(value, ItemTree.class);

        EhrStatus ehrStatus = new EhrStatus("ehr_status", new DvText("ehr_status"), new PartySelf(new PartyRef()), true, true, otherDetails);

        itemStructureVisitor.validate(ehrStatus);
        assertEquals(3, itemStructureVisitor.getElementOccurrences());

    }

    @Test
    public void testValidateTestAllTypesWithInvalidParticipations() throws IOException, JAXBException {
        Unmarshaller unmarshaller = JAXBUtil.getArchieJAXBContext().createUnmarshaller();
        Composition composition = (Composition) unmarshaller.unmarshal(CompositionTestDataCanonicalXML.ALL_TYPES_INVALID_PARTICIPATIONS.getStream());

        try {
            itemStructureVisitor.validate(composition);
            fail("invalid value in participations not detected");
        } catch (Exception e) {

        }
    }


}