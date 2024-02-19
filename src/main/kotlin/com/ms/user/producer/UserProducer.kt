package com.ms.user.producer

import com.ms.user.data.entity.UserEntity
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class UserProducer(
    private val rabbitTemplate: RabbitTemplate,
) {
    @Value("\${broker.queue.email.name}")
    private lateinit var routingKey: String

    fun publishMessageEmail(userEntity: UserEntity) {
        val emailDto = EmailDto(
            userId = userEntity.id!!,
            emailTo = userEntity.email,
            subject = "Cadastro criado com sucesso!",
            text = "${userEntity.name}, seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!"
        )

        rabbitTemplate.convertAndSend("", routingKey, emailDto)
    }
}