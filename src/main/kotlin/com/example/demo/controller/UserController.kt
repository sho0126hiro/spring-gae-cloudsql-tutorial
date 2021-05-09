package com.example.demo.controller

import com.example.demo.domain.service.`interface`.UserService
import com.example.demo.model.request.UserRegisterRequest
import com.example.demo.model.response.UserResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/")
    fun test(): String {
        return "test!!!!"
    }

    @PostMapping("/create")
    fun create(@RequestBody userRequest: UserRegisterRequest): UserResponse {
        return userService.create(
                userRequest
        )
    }

    @GetMapping("/{id}")
    fun getAll(@PathVariable("id") id: Long): UserResponse {
        return userService.findById(id)
    }
}