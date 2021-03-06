/*
 * Copyright 2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.titus.ext.jooqflyway.jobactivity;

import javax.inject.Inject;

import com.netflix.archaius.api.annotations.Configuration;
import com.netflix.titus.common.util.SpringConfigurationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Configuration(prefix = "titus.ext.jooqflyway")
public class JooqConfiguration {

    private static final String PREFIX = "titus.ext.jooqflyway.";
    //private final Environment environment;
    @Autowired
    Environment environment;

    /*@Inject
    public JooqConfiguration(Environment environment) {
        this.environment = environment;
    }*/

    public String getDatabaseUrl() {
        return SpringConfigurationUtil.getString(environment, PREFIX + "databaseUrl", "jdbc://notSet");
    }

    public boolean isInMemoryDb() {
        return SpringConfigurationUtil.getBoolean(environment, PREFIX + "inMemoryDb", false);
    }

    public String getProducerDatatabaseUrl() {
        return SpringConfigurationUtil.getString(environment, PREFIX + "producer.databaseUrl", "jdbc://notSet");
    }
}
