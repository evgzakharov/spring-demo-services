package demo.payment

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties
data class PaymentConfig(
    val timeout: Long
)
