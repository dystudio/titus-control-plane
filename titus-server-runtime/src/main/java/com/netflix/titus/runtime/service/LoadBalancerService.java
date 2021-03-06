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

package com.netflix.titus.runtime.service;

import com.netflix.titus.api.model.callmetadata.CallMetadata;
import com.netflix.titus.grpc.protogen.AddLoadBalancerRequest;
import com.netflix.titus.grpc.protogen.GetAllLoadBalancersRequest;
import com.netflix.titus.grpc.protogen.GetAllLoadBalancersResult;
import com.netflix.titus.grpc.protogen.GetJobLoadBalancersResult;
import com.netflix.titus.grpc.protogen.JobId;
import com.netflix.titus.grpc.protogen.RemoveLoadBalancerRequest;
import rx.Completable;
import rx.Observable;

public interface LoadBalancerService {
    Observable<GetJobLoadBalancersResult> getLoadBalancers(JobId jobId, CallMetadata callMetadata);

    Observable<GetAllLoadBalancersResult> getAllLoadBalancers(GetAllLoadBalancersRequest request, CallMetadata callMetadata);

    Completable addLoadBalancer(AddLoadBalancerRequest request, CallMetadata callMetadata);

    Completable removeLoadBalancer(RemoveLoadBalancerRequest removeLoadBalancerRequest, CallMetadata callMetadata);
}
