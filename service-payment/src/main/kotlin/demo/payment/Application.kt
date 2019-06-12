package demo.payment

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class PaymentApplication

fun main(args: Array<String>) {
    SpringApplication.run(PaymentApplication::class.java, *args)
}
