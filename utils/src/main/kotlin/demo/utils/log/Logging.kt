package demo.utils.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.Instant

interface ILogging {
    val log: Logger
    val serviceName: String

    suspend fun <T> logRequest(method: String? = null, request: suspend () -> T): T {
        val methodInfo = method?.let { "-[$method]" } ?: ""

        log.info("[$serviceName]$methodInfo start request")

        val start = Instant.now()
        val result = request()
        val end = Instant.now()

        val diff = end.toEpochMilli() - start.toEpochMilli()

        log.info("[$serviceName]$methodInfo request end. Time: $diff")

        return result
    }
}

class LoggingImp(
    override val log: Logger,
    override val serviceName: String
) : ILogging {
    companion object {
        operator inline fun <reified T> invoke(serviceName: String): LoggingImp {
            return LoggingImp(LoggerFactory.getLogger(T::class.java), serviceName)
        }
    }
}
