package demo.card

import kotlinx.coroutines.delay
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class User(
    val name: String,
    val surname: String,
    val age: Int
)

@RestController
class UserController(
    private val cardConfig: CardConfig
) {
    val users = mapOf(
        1L to User("Vasia", "Pupkin", 18),
        2L to User("Alfa", "Alfa-bankivich", 100),
        3L to User("Kent", "Kent", 33)
    )

    @GetMapping(value = ["{id}"])
    suspend fun info(
        @PathVariable("id") userId: Long,
        response: ServerHttpResponse
    ): Response {
        delay(cardConfig.timeout)

        val user = users[userId] ?: run {
            response.statusCode = HttpStatus.NOT_FOUND
            return NotFoundResponse(
                error = "user with id='$userId' not found"
            )
        }

        return UserResponse(
            id = userId,
            name = user.name,
            surname = user.surname,
            age = user.age
        )
    }
}
