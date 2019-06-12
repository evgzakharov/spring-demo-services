package demo.auth

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties
data class AuthConfig(
    val successRate: Double,
    val timeout: Long
)
