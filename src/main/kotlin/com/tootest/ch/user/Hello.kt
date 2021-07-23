package com.tootest.ch.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Hello {

    @GetMapping("/hi")
    fun hello(): String {
        return "Hello, Too!";
    }
}