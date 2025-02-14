package org.ehrbase.serialisation.attributes;

import com.nedap.archie.rm.archetyped.FeederAuditDetails;
import com.nedap.archie.rm.composition.Composition;
import com.nedap.archie.rm.datastructures.Element;
import com.nedap.archie.rm.datastructures.ItemSingle;
import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.DvCodedText;
import com.nedap.archie.rm.datavalues.DvText;
import org.apache.commons.io.IOUtils;
import org.ehrbase.serialisation.jsonencoding.CanonicalJson;
import org.ehrbase.test_data.composition.CompositionTestDataCanonicalJson;
import org.junit.Test;

import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class FeederAuditDetailsAttributesTest {

  @Test
  public void toMap() throws Exception {
    String value =
        IOUtils.toString(CompositionTestDataCanonicalJson.FEEDER_AUDIT_DETAILS.getStream(), UTF_8);
    CanonicalJson cut = new CanonicalJson();
    Composition composition = cut.unmarshal(value, Composition.class);

    assertNotNull(composition);
    assertNotNull(composition.getFeederAudit().getFeederSystemAudit().getOtherDetails());

    // with real data
    FeederAuditDetailsAttributes attributes =
        new FeederAuditDetailsAttributes(composition.getFeederAudit().getFeederSystemAudit());
    Map<String, Object> map = attributes.toMap();

    assertNotNull(map);
    assertNotNull(map.get("other_details[openEHR-EHR-ITEM_TREE.generic.v1]"));

    // valid fabricated data without brackets
    FeederAuditDetails details = new FeederAuditDetails();
    ItemSingle single =
        new ItemSingle(
            "test",
            new DvCodedText("text", new CodePhrase("string")),
            new Element("node", new DvText("name"), null));
    details.setOtherDetails(single);
    details.setSystemId("system");
    attributes = new FeederAuditDetailsAttributes(details);
    map = attributes.toMap();

    assertNotNull(map.get("other_details[test]"));

    // valid fabricated data with brackets
    details = new FeederAuditDetails();
    single =
        new ItemSingle(
            "[test]",
            new DvCodedText("text", new CodePhrase("string")),
            new Element("node", new DvText("name"), null));
    details.setOtherDetails(single);
    details.setSystemId("system");
    attributes = new FeederAuditDetailsAttributes(details);
    map = attributes.toMap();

    assertNotNull(map.get("other_details[test]"));

    // invalid data with one [
    details = new FeederAuditDetails();
    single =
        new ItemSingle(
            "[test",
            new DvCodedText("text", new CodePhrase("string")),
            new Element("node", new DvText("name"), null));
    details.setOtherDetails(single);
    details.setSystemId("system");
    attributes = new FeederAuditDetailsAttributes(details);
    assertThrows(IllegalArgumentException.class, attributes::toMap);

    // invalid data with one ]
    details = new FeederAuditDetails();
    single =
        new ItemSingle(
            "test]",
            new DvCodedText("text", new CodePhrase("string")),
            new Element("node", new DvText("name"), null));
    details.setOtherDetails(single);
    details.setSystemId("system");
    attributes = new FeederAuditDetailsAttributes(details);
    assertThrows(IllegalArgumentException.class, attributes::toMap);
  }
}
