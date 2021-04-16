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

package org.ehrbase.client.openehrclient.defaultrestclient.systematic.compositionquery.queries;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.RowProcessorErrorHandler;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.BeanListProcessor;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;

import java.util.Arrays;

public abstract class ParserSettings {

    protected CsvParserSettings settings = new CsvParserSettings();

    public CsvParserSettings settings(){
        settings.getFormat().setComment('#');
        settings.getFormat().setDelimiter(',');
        settings.setHeaderExtractionEnabled(false);
        //skip empty lines
        settings.setSkipEmptyLines(true);
        settings.setProcessorErrorHandler((RowProcessorErrorHandler) (error, inputRow, context) -> {
            throw new IllegalStateException("Error processing row: " + Arrays.toString(inputRow) +
                    " Error details: column '" + error.getColumnName() +
                    "' (index " + error.getColumnIndex() + ") has value '" + inputRow[error.getColumnIndex()] + "'");
        });
        return settings;
    }
}
