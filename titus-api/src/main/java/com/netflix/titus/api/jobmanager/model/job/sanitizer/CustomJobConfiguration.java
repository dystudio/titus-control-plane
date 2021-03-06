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

package com.netflix.titus.api.jobmanager.model.job.sanitizer;

import com.netflix.archaius.api.annotations.DefaultValue;

/**
 * Job specific configuration, currently selected by the job's application name.  Upper bound for all jobs is still
 * enforced by {@link JobConfiguration#getMaxBatchJobSize()} and {@link JobConfiguration#getMaxServiceJobSize()}.
 */
public interface CustomJobConfiguration {

    @DefaultValue("1000")
    int getMaxBatchJobSize();

    @DefaultValue("2500")
    int getMaxServiceJobSize();
}
