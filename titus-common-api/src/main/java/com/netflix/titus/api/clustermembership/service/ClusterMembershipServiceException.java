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

package com.netflix.titus.api.clustermembership.service;

public class ClusterMembershipServiceException extends RuntimeException {

    public enum ErrorCode {
        BadSelfUpdate,
        Internal,
        LocalMemberOnly,
        MemberNotFound,
    }

    private final ErrorCode errorCode;

    private ClusterMembershipServiceException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public static ClusterMembershipServiceException memberNotFound(String memberId) {
        return new ClusterMembershipServiceException(
                ErrorCode.MemberNotFound,
                "Member not found: memberId=" + memberId,
                null
        );
    }

    public static ClusterMembershipServiceException localOnly(String targetId) {
        return new ClusterMembershipServiceException(
                ErrorCode.LocalMemberOnly,
                "Operation limited to the local member data. Call the target member API directly: targetId=" + targetId,
                null
        );
    }

    public static ClusterMembershipServiceException internalError(Throwable cause) {
        return new ClusterMembershipServiceException(
                ErrorCode.Internal,
                "Unexpected internal error: " + cause.getMessage(),
                cause
        );
    }

    public static ClusterMembershipServiceException selfUpdateError(Throwable cause) {
        return new ClusterMembershipServiceException(
                ErrorCode.BadSelfUpdate,
                "Error during updating local membership data: " + cause.getMessage(),
                cause
        );
    }
}
