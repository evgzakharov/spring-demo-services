package demo.auth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class AuthApplication

fun main(args: Array<String>) {
    SpringApplication.run(AuthApplication::class.java, *args)
}
