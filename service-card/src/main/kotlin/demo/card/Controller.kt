package demo.card

import kotlinx.coroutines.delay
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

data class Card(
    val cardId: Long,
    val cardNumber: String,
    val validTo: String
)

@RestController
class AuthController(
    private val cardConfig: CardConfig
) {
    private val cards: Map<String, Card> = listOf(
        Card(1L, "55593478", "03/21"),
        Card(2L, "55592020", "03/21"),
        Card(3L, "55594509", "03/21")
    ).associateBy { it.cardNumber }

    @GetMapping(value = ["{cardNumber}"])
    suspend fun info(
        @PathVariable("cardNumber") cardNumber: String,
        response: ServerHttpResponse
    ): Response {
        delay(cardConfig.timeout)

        val card = cards[cardNumber] ?: run {
            response.statusCode = HttpStatus.NOT_FOUND
            return NotFoundResponse(
                error = "card with number='$cardNumber' not found"
            )
        }

        return CardResponse(
            cardId = card.cardId,
            cardNumber = card.cardNumber,
            validTo = card.validTo
        )
    }
}
