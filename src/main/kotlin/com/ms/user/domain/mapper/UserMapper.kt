package com.ms.user.domain.mapper

import com.ms.user.data.entity.UserEntity
import com.ms.user.domain.dto.UserDto

fun UserDto.toEntity() = UserEntity(
    id = this.id,
    name = this.name,
    email = this.email,
)

fun UserEntity.toDto() = UserDto(
    id = this.id,
    name = this.name,
    email = this.email,
)