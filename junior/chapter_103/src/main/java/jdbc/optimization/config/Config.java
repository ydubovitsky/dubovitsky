package jdbc.optimization.config;

import jdbc.optimization.JAXBParser;
import jdbc.optimization.JAXBParserImpl;
import jdbc.optimization.StoreXML;
import jdbc.optimization.database.Connect;
import jdbc.optimization.database.StoreSQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

/**
 * This class is needed for configuration Spring application;
 * Each method declared as @Bean return Spring-component.
 */
@Configuration
public class Config {

    @Bean
    public Connection connection() {
        Connect connect = new Connect();
        return connect.connection();
    }

    @Bean
    public StoreSQL storeSQL() {
        return new StoreSQL();
    }

    @Bean
    public JAXBParser jaxbParser() {
        return new JAXBParserImpl();
    }

    @Bean
    public StoreXML storeXML() {
        return new StoreXML();
    }
}
