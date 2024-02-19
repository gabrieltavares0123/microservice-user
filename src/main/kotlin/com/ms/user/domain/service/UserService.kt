package com.ms.user.domain.service

import com.ms.user.data.repository.UserRepository
import com.ms.user.domain.dto.UserDto
import com.ms.user.domain.exception.EmailAlreadyUsedException
import com.ms.user.domain.mapper.toDto
import com.ms.user.domain.mapper.toEntity
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) : SaveUser {
    @Transactional
    override fun save(userDto: UserDto): UserDto {
        val userEntity = userDto.toEntity()

        val isEmailAlreadyUsed = userRepository.findByEmail(userEntity.email)
        if (isEmailAlreadyUsed.isPresent) throw EmailAlreadyUsedException()

        val createdUser = userRepository.save(userEntity)
        return createdUser.toDto()
    }
}