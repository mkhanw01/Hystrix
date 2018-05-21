package com.coviam.hystrix.controller.config;


import com.coviam.hystrix.controller.handler.DeserializationHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import java.net.UnknownHostException;

/**
 * @author waseem.khan since 5/17/18.
 */
@Configuration
@ComponentScan("com.coviam.hystrix")
public class BeanConfig {

  @Bean
  public static DeserializationProblemHandler deserializationProblemHandler() {
    return new DeserializationHandler();
  }


  @Bean
  public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoConverter mongoConverter){
    return new MongoTemplate(mongoDbFactory, mongoConverter);
  }

  @Bean
  public static ObjectMapper objectMapper() {
    return new ObjectMapper().addHandler(BeanConfig.deserializationProblemHandler());
  }


  @Bean
  public Mongo createMongo(MongoProperties mongoProperties, Environment environment,
      MongoPropertiesConfig mongoPropertiesConfig) throws UnknownHostException {
    String DESCRIPTION = "mongodb";

    MongoClientOptions options =
        new MongoClientOptions.Builder().writeConcern(WriteConcern.ACKNOWLEDGED)
            .connectionsPerHost(mongoPropertiesConfig.getConnectionPerHost())
            .minConnectionsPerHost(mongoPropertiesConfig.getMinConnectionsPerHost())
            .threadsAllowedToBlockForConnectionMultiplier(
                mongoPropertiesConfig.getThreadsAllowedToBlockForConnectionMultiplier())
            .connectTimeout(mongoPropertiesConfig.getConnectTimeout())
            .maxWaitTime(mongoPropertiesConfig.getMaxWaitTime())
            .socketKeepAlive(mongoPropertiesConfig.getSocketKeepAlive())
            .minHeartbeatFrequency(mongoPropertiesConfig.getMinHeartbeatFrequency())
            .readPreference(ReadPreference.primary()).description(DESCRIPTION).build();

    MongoClient mongoClient = mongoProperties.createMongoClient(options, environment);
    mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
    return mongoClient;
  }

}
