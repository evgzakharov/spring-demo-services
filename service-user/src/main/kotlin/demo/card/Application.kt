package demo.card

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class UserApplication

fun main(args: Array<String>) {
    SpringApplication.run(UserApplication::class.java, *args)
}
