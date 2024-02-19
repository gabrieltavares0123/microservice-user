package com.ms.user.controller

import com.ms.user.domain.exception.EmailAlreadyUsedException
import com.ms.user.domain.exception.ExceptionDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ExceptionHandlerController {
    @ExceptionHandler(EmailAlreadyUsedException::class)
    fun emailAlreadySedExceptionHandler(e: EmailAlreadyUsedException): ResponseEntity<ExceptionDto> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ExceptionDto(e.httpStatus, e.errorMessage)
        )
    }
}