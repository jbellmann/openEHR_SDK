/*
 * Copyright (c) 2021 Jake Smolka (Hannover Medical School) and Vitasystems GmbH
 *
 * This file is part of project EHRbase
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 */

package org.ehrbase.serialisation.dbencoding.rmobject;

import com.nedap.archie.rm.archetyped.Link;
import com.nedap.archie.rm.datavalues.DvEHRURI;
import com.nedap.archie.rm.datavalues.DvText;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinksEncodingTest extends TestCase {

  public void testToDb() {
    LinksEncoding encoding = new LinksEncoding();

    Link link =
        new Link(
            new DvText("something"), new DvText("something else"), new DvEHRURI("ehr://target"));

    String encoded = encoding.toDB(Collections.singletonList(link));

    assertNotNull(encoded);
  }

  public void testFromDbOneLink() {
    LinksEncoding encoding = new LinksEncoding();

    Link link =
        new Link(
            new DvText("something"), new DvText("something else"), new DvEHRURI("ehr://target"));
    List<Link> list = Collections.singletonList(link);

    String encoded = encoding.toDB(list);

    assertNotNull(encoded);

    List<Link> result1 = encoding.fromDB(encoded);
    assertEquals(list, result1);
  }

  public void testFromDbTwoLinks() {
    LinksEncoding encoding = new LinksEncoding();

    Link link =
        new Link(
            new DvText("something"), new DvText("something else"), new DvEHRURI("ehr://target"));
    List<Link> list = Collections.singletonList(link);

    String encoded = encoding.toDB(list);

    assertNotNull(encoded);

    Link link2 =
        new Link(
            new DvText("something2"), new DvText("something else2"), new DvEHRURI("ehr://target2"));
    List<Link> list2 = new ArrayList<Link>();
    list2.add(link);
    list2.add(link2);

    String encoded2 = encoding.toDB(list2);

    List<Link> result2 = encoding.fromDB(encoded2);
    assertEquals(list2, result2);
  }
}
