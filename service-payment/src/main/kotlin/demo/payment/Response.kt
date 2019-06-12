package demo.payment

import java.math.BigDecimal

interface Response {}

data class ErrorResponse(
    val error: String
): Response

data class PaymentSuccessResponse(
    val status: Boolean = true
): Response

data class PaymentTransactionResponse(
    val currentAmount: BigDecimal,
    val transactions: List<TransactionInfo>
): Response
