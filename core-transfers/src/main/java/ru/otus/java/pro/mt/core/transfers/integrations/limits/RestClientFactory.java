package ru.otus.java.pro.mt.core.transfers.integrations.limits;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.otus.java.pro.mt.core.transfers.configs.properties.RestClientProperties;

@Component
public class RestClientFactory {
    private final RestClientProperties properties;

    @Autowired
    public RestClientFactory(@Qualifier("restClientProperties") RestClientProperties properties) {
        this.properties = properties;
    }

    public RestClient createRestClient(String serviceName) {
        RestClientProperties.ServiceConfig config = properties.getServices().get(serviceName);
        if (config == null) {
            throw new IllegalArgumentException("No configuration found for service: " + serviceName);
        }

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout((int) config.getConnectTimeout().toMillis());
        requestFactory.setReadTimeout((int) config.getReadTimeout().toMillis());

        return RestClient.builder()
                .baseUrl(config.getUrl())
                .requestFactory(requestFactory)
                .build();
    }
}
