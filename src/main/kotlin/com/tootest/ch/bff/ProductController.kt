package com.tootest.ch.bff

import com.tootest.ch.bff.dto.ProductResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class ProductController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/product")
    fun product(@RequestParam productCode: String) : ProductResponse {
        logger.info("[ProductInfo] Retrieving product info: productCode={}", productCode)
        val productInfo =  ProductResponse("Test Product", "1234" )
        logger.info("[ProductInfo] Product Info:{}", productInfo)
        return productInfo
    }
}