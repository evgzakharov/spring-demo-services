package demo.card

interface Response {}

data class NotFoundResponse(
    val error: String
): Response

data class CardResponse(
    val cardId: Long,
    val cardNumber: String,
    val validTo: String
): Response
