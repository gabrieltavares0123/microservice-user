package com.ms.user.domain.exception

import org.springframework.http.HttpStatus

data class ExceptionDto(
    val httpStatus: HttpStatus,
    val message: String?,
)
