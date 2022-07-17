package org.api.zing

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class Main

fun main(args: Array<String>) {
    runApplication<Main>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}