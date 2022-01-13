package pokemonApi.pokemonDemo.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoggingController {
    @Bean
    public Logger logger(){
        return LoggerFactory.getLogger(LoggingController.class);
    }
}