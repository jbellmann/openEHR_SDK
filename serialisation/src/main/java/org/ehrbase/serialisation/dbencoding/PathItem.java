/*
 * Copyright (c) 2020 Christian Chevalley (Hannover Medical School) and Vitasystems GmbH
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

package org.ehrbase.serialisation.dbencoding;

import java.util.Map;

import static org.ehrbase.serialisation.dbencoding.CompositionSerializer.TAG_PATH;
import static org.ehrbase.serialisation.dbencoding.CompositionSerializer.WalkerOutputMode;

/** encode the PATH attribute of an Element for the DB */
public class PathItem {

  private Map<String, Object> map;
  private final CompositionSerializer.WalkerOutputMode tagMode;
  private final ItemStack itemStack;

  public PathItem(Map<String, Object> map, WalkerOutputMode tagMode, ItemStack itemStack) {
    this.map = map;
    this.tagMode = tagMode;
    this.itemStack = itemStack;
  }

  public Map<String, Object> encode(String tag) {
    Map<String, Object> retMap = map;

    switch (tagMode) {
      case PATH:
        retMap =
            new SerialTree(map)
                .insert(
                    null,
                    (Object) null,
                    TAG_PATH,
                    tag == null ? itemStack.pathStackDump() : itemStack.pathStackDump() + tag);
        break;
      case NAMED:
        retMap =
            new SerialTree(map)
                .insert(
                    null,
                    (Object) null,
                    TAG_PATH,
                    tag == null
                        ? itemStack.namedStackDump()
                        : itemStack.namedStackDump() + tag.substring(1));
        break;
      case EXPANDED:
        retMap =
            new SerialTree(map)
                .insert(
                    null,
                    (Object) null,
                    TAG_PATH,
                    tag == null
                        ? itemStack.expandedStackDump()
                        : itemStack.expandedStackDump() + tag.substring(1));
        break;
      case RAW:
        break;
      default:
        throw new IllegalArgumentException("Invalid tagging mode!");
    }

    return retMap;
  }
}
