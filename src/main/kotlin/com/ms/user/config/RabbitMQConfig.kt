package com.ms.user.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {
    @Bean
    fun messageConverter(): Jackson2JsonMessageConverter {
        val objectMapper = ObjectMapper()
        objectMapper.registerKotlinModule()
        return Jackson2JsonMessageConverter(objectMapper)
    }
}