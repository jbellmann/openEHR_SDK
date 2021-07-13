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

package org.ehrbase.serialisation.walker;

import com.nedap.archie.rm.RMObject;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.ehrbase.serialisation.walker.defaultvalues.DefaultValues;
import org.ehrbase.webtemplate.model.WebTemplateNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Context<T> {

  private final Deque<WebTemplateNode> nodeDeque = new ArrayDeque<>();

  private final Deque<RMObject> rmObjectDeque = new ArrayDeque<>();

  private final Deque<T> objectDeque = new ArrayDeque<>();

  private final Map<NodeId, Integer> countMap = new HashMap<>();

  private Map<Pair<String, String>, Deque<WebTemplateNode>> filteredNodeMap;
  private DefaultValues defaultValues;

  private final FlatHelper<T> flatHelper = new FlatHelper<>();

  public Deque<WebTemplateNode> getNodeDeque() {
    return nodeDeque;
  }

  public Deque<RMObject> getRmObjectDeque() {
    return rmObjectDeque;
  }

  public Deque<T> getObjectDeque() {
    return objectDeque;
  }

  public Map<NodeId, Integer> getCountMap() {
    return countMap;
  }

  public Deque<WebTemplateNode> getSkippedNodes(WebTemplateNode childNode) {
    Deque<WebTemplateNode> skippedNodes = null;
    if (this.filteredNodeMap != null) {
      skippedNodes =
          this.filteredNodeMap.get(
              new ImmutablePair<>(childNode.getAqlPath(), childNode.getRmType()));
    }
    return skippedNodes;
  }

  public void setFilteredNodeMap(
      Map<Pair<String, String>, Deque<WebTemplateNode>> filteredNodeMap) {
    this.filteredNodeMap = filteredNodeMap;
  }

  public Map<Pair<String, String>, Deque<WebTemplateNode>> getFilteredNodeMap() {
    return filteredNodeMap;
  }

  public DefaultValues getDefaultValues() {
    return defaultValues;
  }

  public void setDefaultValues(DefaultValues defaultValues) {
    this.defaultValues = defaultValues;
  }

  public FlatHelper<T> getFlatHelper() {
    return flatHelper;
  }
}
