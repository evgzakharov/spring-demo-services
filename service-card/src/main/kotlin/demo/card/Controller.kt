package demo.card

import demo.utils.log.ILogging
import demo.utils.log.LoggingImp
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
): ILogging by LoggingImp<AuthController>("service-card")  {
    private val cards: Map<String, Card> = listOf(
        Card(1L, "55593478", "03/21"),
        Card(2L, "55592020", "03/21"),
        Card(3L, "55594509", "03/21")
    ).associateBy { it.cardNumber }

    @GetMapping(value = ["{cardNumber}"])
    suspend fun info(
        @PathVariable("cardNumber") cardNumber: String,
        response: ServerHttpResponse
    ): Response = logRequest {
        delay(cardConfig.timeout)

        val card = cards[cardNumber] ?: run {
            response.statusCode = HttpStatus.NOT_FOUND
            return@logRequest NotFoundResponse(
                error = "card with number='$cardNumber' not found"
            )
        }

        CardResponse(
            cardId = card.cardId,
            cardNumber = card.cardNumber,
            validTo = card.validTo
        )
    }
}
