package jdbc.optimization.config;

import jdbc.optimization.jaxb.JAXBParser;
import jdbc.optimization.jaxb.JAXBParserImpl;
import jdbc.optimization.StoreXML;
import jdbc.optimization.database.Connect;
import jdbc.optimization.database.StoreSQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
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

    @Bean
    public File getFile() {
        File file = null;
        try {
            file = File.createTempFile("temp", ".xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
