package com.coviam.hystrix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author waseem.khan since 5/19/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "info")
public class Info {

  @Id
  private String userId;
  private String fistName;

  private String lastName;

  private String sex;

  private String address;
}
