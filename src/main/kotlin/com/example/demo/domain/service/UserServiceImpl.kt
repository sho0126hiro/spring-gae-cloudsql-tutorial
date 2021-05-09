package com.example.demo.domain.service

import com.example.demo.domain.repository.UserRepository
import com.example.demo.domain.service.`interface`.UserService
import com.example.demo.model.entity.User
import com.example.demo.model.entity.UserRole
import com.example.demo.model.request.UserRegisterRequest
import com.example.demo.model.response.UserResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun create(user: UserRegisterRequest): UserResponse {
        val user = userRepository.save(
                User(
                        email = user.email,
                        password = user.password,
                        role = UserRole.MEMBER,
                )
        )
        return UserResponse(
                id = user.id,
                email = user.email,
                password = user.password,
                role = user.role,
                username = user.username,
                profileImgUrl = user.profileImgUrl,
                name = user.name
        )
    }

    override fun findById(id: Long): UserResponse {
        val user = userRepository.findById(id)
        return UserResponse(
            id = user.id,
            email = user.email,
            password = user.password,
            role = user.role,
            username = user.username,
            profileImgUrl = user.profileImgUrl,
            name = user.name
        )
    }
}