package com.smartextension.backend.repositonries

import com.smartextension.backend.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.stereotype.Component

@Component
@EnableWebSecurity
open class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var detailsService: DetailsService

    @Throws(Exception::class)
    override fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder?) {
        authenticationManagerBuilder?.userDetailsService(detailsService)?.passwordEncoder(
                User.PASSWORD_ENCODER)
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
                ?.anyRequest()?.authenticated()
                ?.and()
                ?.httpBasic()
                ?.and()
                ?.csrf()?.disable()
    }
}