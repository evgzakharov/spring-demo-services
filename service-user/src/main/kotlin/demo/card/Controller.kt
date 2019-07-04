package demo.card

import demo.utils.log.ILogging
import demo.utils.log.LoggingImp
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
): ILogging by LoggingImp<UserController>("service-user") {
    val users = mapOf(
        1L to User("Vasia", "Pupkin", 18),
        2L to User("Alfa", "Alfa-bankivich", 100),
        3L to User("Kent", "Kent", 33)
    )

    @GetMapping(value = ["{id}"])
    suspend fun info(
        @PathVariable("id") userId: Long,
        response: ServerHttpResponse
    ): Response = logRequest {
        delay(cardConfig.timeout)

        val user = users[userId] ?: run {
            response.statusCode = HttpStatus.NOT_FOUND
            return@logRequest NotFoundResponse(
                error = "user with id='$userId' not found"
            )
        }

        UserResponse(
            id = userId,
            name = user.name,
            surname = user.surname,
            age = user.age
        )
    }
}
