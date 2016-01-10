package tvless;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tvless.catalog.CatalogService;

@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        new TvlessApplication(ApiApplication.class).run(args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new CustomObjectMapper();
    }

}
