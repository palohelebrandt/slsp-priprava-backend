package com.slsp.test1kotlin.configuration

import lombok.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    private val corsOriginPatterns: String = "http://localhost:3000/"

    @Bean
    fun addCorsConfig(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: org.springframework.web.servlet.config.annotation.CorsRegistry) {
                val allowedOrigins = corsOriginPatterns.split(",").toTypedArray()
                registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOriginPatterns(*allowedOrigins)
                    .allowCredentials(true)
            }
        }
    }
}