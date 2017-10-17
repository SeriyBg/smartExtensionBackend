package com.smartextension.backend

import org.springframework.http.client.ClientHttpRequest
import org.springframework.security.oauth2.client.DefaultOAuth2RequestAuthenticator
import org.springframework.security.oauth2.client.OAuth2ClientContext
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails
import org.springframework.security.oauth2.common.OAuth2AccessToken

class GoogleOAuth2Authenticator : DefaultOAuth2RequestAuthenticator() {

    override fun authenticate(resource: OAuth2ProtectedResourceDetails,
                              clientContext: OAuth2ClientContext, request: ClientHttpRequest) {
        System.out.print("override fun authenticate(resource: OAuth2ProtectedResourceDetails,")
        val accessToken = clientContext.accessToken
        val tokenType = OAuth2AccessToken.BEARER_TYPE
        request.headers.set("Authorization", String.format("%s %s", tokenType, accessToken.value))
    }
}