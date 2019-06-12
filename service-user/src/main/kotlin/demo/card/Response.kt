package demo.card

interface Response {}

data class NotFoundResponse(
    val error: String
): Response

data class UserResponse(
    val id: Long,
    val name: String,
    val surname: String,
    val age: Int
): Response
