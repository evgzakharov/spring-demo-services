package demo.payment

import java.math.BigDecimal

data class PaymentRequest(
    val cardIdFrom: Long,
    val cardIdTo: Long,
    val amount: BigDecimal
)
