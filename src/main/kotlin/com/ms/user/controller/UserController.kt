package com.ms.user.controller

import com.ms.user.domain.dto.UserDto
import com.ms.user.domain.exception.EmailAlreadyUsedException
import com.ms.user.domain.exception.ExceptionDto
import com.ms.user.domain.service.SaveUser
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val saveUser: SaveUser,
) {
    @PostMapping
    fun create(
        @RequestBody
        @Valid
        userDto: UserDto
    ): ResponseEntity<UserDto> {
        try {
            val createdUser = saveUser.save(userDto)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
        } catch (ex: EmailAlreadyUsedException) {
            throw EmailAlreadyUsedException()
        }
    }
}