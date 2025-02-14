/*
 * Copyright (c) 2019 Stefan Spiska (Vitasystems GmbH) and Hannover Medical School.
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

package org.ehrbase.serialisation;

import com.nedap.archie.rm.RMObject;
import com.nedap.archie.rm.composition.Composition;

public interface RMDataFormat {

    String marshal(RMObject rmObject);

    <T extends RMObject> T unmarshal(String value, Class<T> clazz);

    default Composition unmarshal(String value){

        return unmarshal(value,Composition.class);
    }

}
