package com.coviam.hystrix.controller.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author waseem.khan since 5/16/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MandatoryParameter implements Serializable {

  private static final long serialVersionUID = -3321968787113039156L;

  private String userName;
}
