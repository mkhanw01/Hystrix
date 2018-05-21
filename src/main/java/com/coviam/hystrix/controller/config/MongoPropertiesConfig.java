package com.coviam.hystrix.controller.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author waseem.khan since 5/21/18.
 */
@Component
@ConfigurationProperties(prefix = "hystrix.mongo")
@Setter
@Getter
public class MongoPropertiesConfig {
  private Integer connectionPerHost;

  private Integer minConnectionsPerHost;

  private Integer threadsAllowedToBlockForConnectionMultiplier;

  private Integer connectTimeout;

  private Integer maxWaitTime;

  private Boolean autoConnectRetry;

  private Boolean socketKeepAlive;

  private Integer minHeartbeatFrequency;

  private String description;
}
