package demo.auth

interface Response {}

data class ForbiddenResponse (
    val error: String
): Response

data class AuthResponse(
    val userId: Long,
    val cardAccess: Boolean = false,
    val paymentAccess: Boolean = false,
    val userAccess: Boolean = false
): Response
