package pokemonApi.pokemonDemo.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pokemonApi.pokemonDemo.adapter.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo()).useDefaultResponseMessages(false)
                ;
    }

    private ApiInfo getApiInfo(){
        return new ApiInfo(
                "Pokemon Api",
                "",
                "1.0",
                "https://github.com/Al3xCodeMaster/pokemonApi",
                new Contact("Alexander", "https://github.com/Al3xCodeMaster/pokemonApi", "gonzalez.alexander@correounivalle.edu.co"),
                "LICENSE-2.0",
                "https://www.apache.org/licenses/LICENSE-2.0.html",
                Collections.emptyList()
        );
    }

}
