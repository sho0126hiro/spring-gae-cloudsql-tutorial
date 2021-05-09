package com.example.demo.domain.repository

import com.example.demo.model.entity.User


interface UserRepository {
    fun save(user: User): User
    fun findById(id: Long): User
}