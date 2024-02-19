package com.ms.user.producer

import java.util.UUID

data class EmailDto(
    val userId: UUID,
    val emailTo: String,
    val subject: String,
    val text: String,
)
