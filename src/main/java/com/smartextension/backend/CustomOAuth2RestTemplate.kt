package com.smartextension.backend

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer
import org.springframework.security.oauth2.client.OAuth2RestTemplate

class CustomOAuth2RestTemplate : UserInfoRestTemplateCustomizer {

    override fun customize(template: OAuth2RestTemplate) {
        // TODO Auto-generated method stub
        System.out.print("CustomOAuth2RestTemplate")
        template.setAuthenticator(GoogleOAuth2Authenticator())
    }
}