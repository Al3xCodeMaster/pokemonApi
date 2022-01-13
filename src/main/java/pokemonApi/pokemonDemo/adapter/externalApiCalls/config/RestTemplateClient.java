package pokemonApi.pokemonDemo.adapter.externalApiCalls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RestTemplateClient {
    @Bean
    public org.springframework.web.client.RestTemplate restTemplate() {
        return new org.springframework.web.client.RestTemplate();
    }
}
