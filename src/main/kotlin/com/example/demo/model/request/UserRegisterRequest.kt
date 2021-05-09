package com.example.demo.model.request

import javax.validation.constraints.NotNull

data class UserRegisterRequest(
        @field:NotNull
        val email: String,
        @field:NotNull
        val password: String,
)