package com.coviam.hystrix.controller.interceptor;

import com.coviam.hystrix.controller.config.MandatoryParameter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author waseem.khan since 5/16/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MandatoryParameterInterceptor extends HandlerInterceptorAdapter {

  public static String PARAMETER = "mandatory";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    MandatoryParameter parameter = this.getMandatoryParameter(request);
    request.setAttribute(PARAMETER, parameter);
    return true;
  }

  private MandatoryParameter getMandatoryParameter(HttpServletRequest request) {
    String USER_NAME = request.getHeader("userName");
    return new MandatoryParameter(USER_NAME);
  }
}
