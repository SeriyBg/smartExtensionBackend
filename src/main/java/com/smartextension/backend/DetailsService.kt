package com.smartextension.backend

import com.smartextension.backend.datalayer.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
open class DetailsService : UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        username?.let {
            val user = userRepository.findByUsername(it)
            user?.let {
                return org.springframework.security.core.userdetails.User(
                        it.username, it.password,
                        AuthorityUtils.createAuthorityList(it.role))
            } ?: let { throw UsernameNotFoundException("$username was not found") }
        } ?: let { throw UsernameNotFoundException("$username was not found") }
    }
}