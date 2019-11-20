package demo.auth

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "service")
data class AuthConfig(
    val successRate: Double,
    val timeout: Long
)
