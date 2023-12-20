package com.pluralsight.ledger.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Configuration class for setting up the database connection.
 * This class uses Spring's dependency injection to set the properties of the data source.
 */
@Configuration // This annotation marks the class as a configuration class for Spring.
public class DatabaseConfiguration {

    private BasicDataSource dataSource; // Apache Commons DBCP's BasicDataSource for connection pooling.

    /**
     * Creates a DataSource bean that will be managed by the Spring container.
     *
     * @return a configured DataSource object.
     */
    @Bean // This annotation marks the method to return a bean that will be managed by the Spring container.
    public DataSource dataSource() {
        return dataSource;
    }

    /**
     * Constructor to create a BasicDataSource with the provided configurations.
     * The @Autowired annotation is used for constructor injection.
     *
     * @param url the URL of the database.
     * @param username the username for the database connection.
     * @param password the password for the database connection.
     */
    @Autowired // This annotation marks the constructor for dependency injection by Spring.
    public DatabaseConfiguration(@Value("${datasource.url}") String url,
                                 @Value("${datasource.username}") String username,
                                 @Value("${datasource.password}") String password) {
        dataSource = new BasicDataSource(); // Instantiating BasicDataSource object.
        dataSource.setUrl(url); // Setting the database URL.
        dataSource.setUsername(username); // Setting the database username.
        dataSource.setPassword(password); // Setting the database password.

        // Printing the database connection details. (Note: In a production environment, it's not recommended to print credentials)
        System.out.println(url + " : " + username + " : " + password);
    }
}
