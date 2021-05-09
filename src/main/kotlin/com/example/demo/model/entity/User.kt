package com.example.demo.model.entity

import javax.persistence.*

enum class UserRole(val role: String) {
    ADMIN("ADMIN"),
    MEMBER("MEMBER")
}

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val email: String,
    val password: String,
    val username: String? = null,
    val name: String? = null,
    val profileImgUrl: String? = null,
    val role: UserRole? = null
)