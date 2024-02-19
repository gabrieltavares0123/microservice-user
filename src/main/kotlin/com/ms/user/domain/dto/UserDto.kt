package com.ms.user.domain.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import java.util.*

data class UserDto(
    val id: UUID? = null,
    @field:NotBlank
    val name: String,
    @field:NotBlank
    @field:Email
    val email: String
)
