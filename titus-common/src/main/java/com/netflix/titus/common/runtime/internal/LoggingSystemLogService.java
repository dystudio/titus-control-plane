/*
 * Copyright 2018 Netflix, Inc.
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

package com.netflix.titus.common.runtime.internal;

import com.netflix.titus.common.runtime.SystemLogEvent;
import com.netflix.titus.common.runtime.SystemLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingSystemLogService implements SystemLogService {

    private static final Logger logger = LoggerFactory.getLogger(LoggingSystemLogService.class);

    private static final LoggingSystemLogService INSTANCE = new LoggingSystemLogService();

    public static LoggingSystemLogService getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean submit(SystemLogEvent event) {
        switch (event.getPriority()) {
            case Info:
                logger.info("System event: {}", event);
                break;
            case Warn:
                logger.warn("System event: {}", event);
                break;
            case Error:
            case Fatal:
                logger.error("System event: {}", event);
                break;
        }
        return true;
    }
}
