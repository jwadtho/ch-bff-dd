package com.tootest.ch.bff

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/hi")
    fun hello() : String {
        logger.info("Hi, there")
        return "Hi, there"
    }
}