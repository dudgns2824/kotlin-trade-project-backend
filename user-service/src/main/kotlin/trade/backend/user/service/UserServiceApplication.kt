package trade.backend.user.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["trade.backend.user.service.adapter.out.jpa.repository"])
@SpringBootApplication(
    scanBasePackages = [
        "trade.backend.user.service",
    ],
)
@EntityScan(
    basePackages = [
        "trade.backend.user.service",
    ],
)
class UserServiceApplication

fun main(args: Array<String>) {
    runApplication<UserServiceApplication>(*args)
}
