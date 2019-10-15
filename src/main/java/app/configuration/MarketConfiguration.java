package app.configuration;

import app.services.DbService;
import app.services.DbServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarketConfiguration {

    @Bean
    DbService dbService (){
        return new DbServiceImpl();
    }
}
