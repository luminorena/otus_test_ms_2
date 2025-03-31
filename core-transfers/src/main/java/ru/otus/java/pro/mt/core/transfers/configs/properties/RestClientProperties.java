package ru.otus.java.pro.mt.core.transfers.configs.properties;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;

@Component
@ConfigurationProperties("rest-client")
@Data
@Slf4j
public class RestClientProperties {
    private Map<String, ServiceConfig> services;

    @PostConstruct
    public void logLoadedProperties() {
       log.info("Loaded services: {} ", services);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ServiceConfig {
        private String url;
        private Duration readTimeout;
        private Duration connectTimeout;
    }
}
