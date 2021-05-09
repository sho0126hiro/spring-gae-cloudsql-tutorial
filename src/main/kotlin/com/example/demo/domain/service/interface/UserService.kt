package com.example.demo.domain.service.`interface`

import com.example.demo.model.request.UserRegisterRequest
import com.example.demo.model.response.UserResponse

interface UserService {
    fun create(user: UserRegisterRequest): UserResponse
    fun findById(id: Long): UserResponse
}