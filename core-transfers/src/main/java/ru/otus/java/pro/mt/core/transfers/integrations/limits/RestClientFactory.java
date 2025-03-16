package ru.otus.java.pro.mt.core.transfers.integrations.limits;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import ru.otus.java.pro.mt.core.transfers.configs.properties.RestClientProperties;

@Configuration
public class RestClientFactory {

    @Bean
    public RestClient restClient(RestClientProperties properties) {
        return RestClient.builder()
                .baseUrl(properties.getUrl())
                .requestFactory(requestFactory(properties))
                .build();
    }

    private ClientHttpRequestFactory requestFactory(RestClientProperties props) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(props.getConnectTimeout());
        factory.setReadTimeout(props.getReadTimeout());
        return factory;
    }

}
