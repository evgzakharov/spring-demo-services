package demo.auth

import kotlinx.coroutines.delay
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class AuthController(
    val authConfig: AuthConfig
) {
    private val userTokens = mapOf(
        "auth-token1" to 1L,
        "auth-token2" to 2L,
        "auth-token3" to 3L
    )

    @GetMapping(value = ["{token}"])
    suspend fun info(
        @PathVariable(name = "token") token: String,
        response: ServerHttpResponse
    ): Response {
        delay(authConfig.timeout)

        val userId = userTokens[token] ?: run {
            response.statusCode = HttpStatus.FORBIDDEN
            return ForbiddenResponse(
                error = "access is forbidden for token='$token' (token not find)"
            )
        }

        return AuthResponse(
            userId = userId,
            cardAccess = Random.nextDouble() <= authConfig.successRate,
            paymentAccess = Random.nextDouble() <= authConfig.successRate,
            userAccess = Random.nextDouble() <= authConfig.successRate
        )
    }
}
