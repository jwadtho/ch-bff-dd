package com.tootest.ch.bff.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@OnJaeger
@Component
@ConfigurationProperties(prefix = "jaeger")
data class JaegerProperties(
    var serviceName: String? = null,
    var endpoint: String? = null
)