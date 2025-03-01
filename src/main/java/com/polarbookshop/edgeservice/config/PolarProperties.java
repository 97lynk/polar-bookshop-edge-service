package com.polarbookshop.edgeservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "polar") // already listening to RefreshScopeRefreshedEvent
public class PolarProperties {

    /**
     * A message to welcome users.
     */
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}