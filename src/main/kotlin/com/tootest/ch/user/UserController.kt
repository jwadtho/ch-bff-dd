package com.tootest.ch.user

import com.tootest.ch.user.dto.UserResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/user")
    fun user(@RequestParam email: String) : UserResponse {
        logger.info("[UserInfo] Retrieving user info: email={}", email)
        val userInfo =  UserResponse( email, "Name1", "lastName1")
        logger.info("[UserInfo] User Info:{}", userInfo)
        return userInfo
    }

}