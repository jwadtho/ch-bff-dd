package com.tootest.ch.bff

import com.tootest.ch.bff.dto.ProductResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import khttp.get as httpGet

@RestController
class ProductController(@Value("\${ch.user.endpoint}") val chUserEndpoint: String? = null) {

    private val logger = LoggerFactory.getLogger(javaClass)


    @GetMapping("/product")
    fun product(@RequestParam productCode: String, @RequestParam(required = false) email: String): ProductResponse {
        logger.info("[ProductInfo] Retrieving product info: productCode={}, email:{}", productCode, email)
        val productInfo = ProductResponse("Test Product", productCode)
        logger.info("[ProductInfo] Product Info:{}", productInfo)

        if (email != "") {
            val endpoint = "${chUserEndpoint}/user"
            val x = httpGet(
                url = endpoint,
                params = mapOf("email" to email)
            )
            logger.info("[ProductInfo] Response from User API: statusCode:${x.statusCode}, text: ${x.text}")
            if (x.statusCode == 200) {
                productInfo.backendInfo = "Can connect to backend with email: $email"
            } else {
                throw Exception("Could not callout get user, url:$endpoint")
            }
        }


        return productInfo
    }
}