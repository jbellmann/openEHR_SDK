/*
 *
 *  *  Copyright (c) 2020  Stefan Spiska (Vitasystems GmbH) and Hannover Medical School
 *  *  This file is part of Project EHRbase
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *
 *  *  http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *
 */

package org.ehrbase.client.std.marshal.config;

import com.nedap.archie.rm.datavalues.encapsulated.DvMultimedia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DvMultimediaConfig extends AbstractsStdConfig<DvMultimedia> {


    /**
     * {@inheritDoc}
     */
    @Override
    public Class<DvMultimedia> getAssociatedClass() {
        return DvMultimedia.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> buildChildValues(String currentTerm, DvMultimedia rmObject) {
        Map<String, Object> result = new HashMap<>();
        addValue(result, currentTerm, null, rmObject.getUri().getValue());
        addValue(result, currentTerm, "mediatype", rmObject.getMediaType().getCodeString());
        addValue(result, currentTerm, "size", rmObject.getSize());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> valueCount(Class<DvMultimedia> clazz) {
        return List.of(3);
    }
}
