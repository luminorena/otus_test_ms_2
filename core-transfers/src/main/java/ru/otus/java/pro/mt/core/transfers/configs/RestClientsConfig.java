package ru.otus.java.pro.mt.core.transfers.configs;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.otus.java.pro.mt.core.transfers.configs.properties.LimitsIntegrationProperties;
import ru.otus.java.pro.mt.core.transfers.configs.properties.RestClientProperties;
import ru.otus.java.pro.mt.core.transfers.integrations.limits.RestClientFactory;

@Configuration
@AllArgsConstructor
public class RestClientsConfig {

    private final RestClientFactory restClientFactory;


    // @Bean
    public RestTemplate commonRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestClient limitsClient(RestClientProperties restClientProperties){
        return restClientFactory.restClient(restClientProperties);
    }
}
