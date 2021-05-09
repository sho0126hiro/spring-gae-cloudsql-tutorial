package com.example.demo.repository

import com.example.demo.domain.repository.UserRepository
import com.example.demo.model.entity.User
import com.example.demo.repository.jpaRepository.UserJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl (
    val userRepository: UserJpaRepository
    ): UserRepository
{
    override fun save(user: User): User {
        return userRepository.save(user)
    }

    override fun findById(id: Long): User {
        val entity = userRepository.findById(id).orElse(null)
        if (entity == null) TODO("TODO")
        else {
            return entity
        }
    }
}