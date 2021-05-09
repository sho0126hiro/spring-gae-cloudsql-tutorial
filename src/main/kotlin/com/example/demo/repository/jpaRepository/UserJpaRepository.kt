package com.example.demo.repository.jpaRepository
import com.example.demo.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository: JpaRepository<User, Long> {
}