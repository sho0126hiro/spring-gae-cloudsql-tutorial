package com.example.demo.model.response

import com.example.demo.model.entity.UserRole


data class UserResponse (
        val id: Long?,
        val email: String,
        val password: String,
        val username: String?,
        val name: String? = null,
        val profileImgUrl: String? = null,
        val role: UserRole? = null
)