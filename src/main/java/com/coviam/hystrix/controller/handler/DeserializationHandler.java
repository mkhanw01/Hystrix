package com.coviam.hystrix.controller.handler;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author waseem.khan since 5/16/18.
 */
@Slf4j
public class DeserializationHandler extends DeserializationProblemHandler {

  @Override
  public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser p,
      JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName)
      throws IOException {
    log.warn("unknown fields :{}",propertyName);
    return true;
  }
}
