package ru.otus.java.pro.mt.core.transfers.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.otus.java.pro.mt.core.transfers.integrations.limits.RestClientFactory;

@Configuration
public class RestClientsConfig {

    private final RestClientFactory restClientFactory;

    public RestClientsConfig(RestClientFactory restClientFactory) {
        this.restClientFactory = restClientFactory;
    }

    @Bean("serviceA")
    public RestClient serviceARestClient() {
        return restClientFactory.createRestClient("serviceA");
    }

    @Bean("serviceB")
    public RestClient serviceBRestClient() {
        return restClientFactory.createRestClient("serviceB");
    }

}
