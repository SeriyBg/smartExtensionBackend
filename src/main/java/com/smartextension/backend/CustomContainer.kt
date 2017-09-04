package com.smartextension.backend

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.stereotype.Component

@Component
class CustomContainer : EmbeddedServletContainerCustomizer {

    override fun customize(container: ConfigurableEmbeddedServletContainer) {
        container.setPort(8083)
    }

}