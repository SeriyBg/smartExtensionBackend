package com.smartextension.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer

@SpringBootApplication
@EnableOAuth2Sso
open class Application {

    val customOauth2Template : UserInfoRestTemplateCustomizer = CustomOAuth2RestTemplate()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}
