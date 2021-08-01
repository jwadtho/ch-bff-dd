package com.tootest.ch.bff.configuration

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@ConditionalOnProperty(name=["jaeger.enabled"], havingValue="true")
@Component
@ConfigurationProperties(prefix = "jaeger")
data class JaegerProperties(
    var serviceName: String? = null,
    var endpoint: String? = null
)