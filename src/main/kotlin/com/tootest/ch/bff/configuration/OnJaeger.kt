package com.tootest.ch.bff.configuration

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty

@ConditionalOnProperty(prefix = "jaeger", name = ["enabled"], havingValue = "true")
annotation class OnJaeger 