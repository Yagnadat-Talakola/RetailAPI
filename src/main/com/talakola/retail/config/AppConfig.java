package com.talakola.retail.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${spring.datasource.host}")
    private String hostName;

    @Value("${spring.datasource.port}")
    private int portNum;

    @Value("${spring.datasource.db}")
    private String dbName;

    @Value("${spring.datasource.collection}")
    private String collectionName;

    @Bean
    public MongoClient getMongoClient() {
        return new MongoClient(hostName, portNum);
    }

    @Bean
    public MongoDatabase getMongoDatabase() {
        return getMongoClient().getDatabase(dbName);
    }

    @Bean
    public MongoCollection<Document> getMongoCollection() {
        return getMongoDatabase().getCollection(collectionName);
    }
}
