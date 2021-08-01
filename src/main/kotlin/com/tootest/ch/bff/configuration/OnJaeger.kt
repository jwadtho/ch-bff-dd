package com.tootest.ch.bff.configuration

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Profile


@Profile("jaeger")
//@ConditionalOnProperty(prefix = "jaeger", name = ["enabled"], havingValue = "true")
annotation class OnJaeger 