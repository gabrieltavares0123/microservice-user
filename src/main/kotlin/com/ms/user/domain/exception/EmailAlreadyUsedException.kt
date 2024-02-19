package com.ms.user.domain.exception

import org.springframework.http.HttpStatus

class EmailAlreadyUsedException(
    val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    val errorMessage: String = "E-mail already used."
) : RuntimeException()