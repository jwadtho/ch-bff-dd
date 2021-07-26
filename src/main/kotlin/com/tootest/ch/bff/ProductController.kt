package com.tootest.ch.bff

import com.tootest.ch.bff.dto.ProductResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import khttp.get as httpGet

@RestController
class ProductController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/product")
    fun product(@RequestParam productCode: String, @RequestParam(required = false) email: String) : ProductResponse {
        logger.info("[ProductInfo] Retrieving product info: productCode={}, email:{}", productCode, email)
        val productInfo =  ProductResponse("Test Product", productCode )
        logger.info("[ProductInfo] Product Info:{}", productInfo)

        if (email != null && email != ""){
            val endpoint = "http://user-service.tootest.svc.cluster.local:9211/user"
            try {
                val x = httpGet(
                    url = endpoint,
                    params = mapOf("email" to email)
                )
            } catch (ex: Exception) {
                logger.error("Could not callout get user, url:$endpoint", ex)
                throw ex
            }
        }


        return productInfo
    }
}