package com.ms.user.domain.service

import com.ms.user.domain.dto.UserDto

interface SaveUser {
    fun save(userDto: UserDto): UserDto
}