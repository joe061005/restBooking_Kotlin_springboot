package com.project.lunchBooking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
class LunchBookingApplication

fun main(args: Array<String>) {
    runApplication<LunchBookingApplication>(*args)
}

