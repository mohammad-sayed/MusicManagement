package com.ms.musicmanagement.shared.datasource.backend.constant

enum class BackendErrorCode(val value: Int) {
    UNKNOWN(-1),
    INVALID_SERVICE(2),
    INVALID_METHOD(3),
    AUTHENTICATION_FAILED(4),
    INVALID_FORMAT(5),
    INVALID_PARAMETERS(6),
    INVALID_RESOURCE_SPECIFIED(7),
    OPERATION_FAILED(8),
    INVALID_SESSION_KEY(9),
    INVALID_API_KEY(10),
    SERVICE_OFFLINE(11),
    INVALID_METHOD_SIGNATURE_SUPPLIED(13),
    TEMPORARY_ERROR(16),
    SUSPENDED_API_KEY(26),
    RATE_LIMIT_EXCEEDED(29);

    companion object {
        fun fromValue(value: Int): BackendErrorCode? {
            return values().firstOrNull { it.value == value }
        }
    }
}
