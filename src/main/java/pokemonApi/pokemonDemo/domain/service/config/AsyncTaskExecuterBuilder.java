package pokemonApi.pokemonDemo.domain.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

// Parameters of ThreadPoolTaskExecutor can be adjusted to provide better performance or prevent overhead
@Component
public class AsyncTaskExecuterBuilder {
    @Bean
    public AsyncTaskExecutor asyncTaskExecutor(){
        ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
        exec.setCorePoolSize(5);
        exec.setMaxPoolSize(10);
        exec.initialize();

        return exec;
    }
}
