package demo.card

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties
data class CardConfig(
    val timeout: Long
)
