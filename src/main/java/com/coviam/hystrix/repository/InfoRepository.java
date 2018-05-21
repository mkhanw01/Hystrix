package com.coviam.hystrix.repository;

import com.coviam.hystrix.Info;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author waseem.khan since 5/19/18.
 */
public interface InfoRepository  extends MongoRepository<Info, String> {
  /**
   * thsi method will return info document based on firstName
   * @param userName it should not be null
   * @return info document
   */
  Info findByUserName(String userName);
}
