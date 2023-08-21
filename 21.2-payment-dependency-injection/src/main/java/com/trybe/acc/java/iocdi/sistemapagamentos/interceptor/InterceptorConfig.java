package com.trybe.acc.java.iocdi.sistemapagamentos.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Interceptor config.
 */
public class InterceptorConfig implements WebMvcConfigurer {
  private Interceptor interceptor;

  /**
   * Instantiates a new Interceptor config.
   *
   * @param interceptor the interceptor
   */
  public InterceptorConfig(Interceptor interceptor) {
    this.interceptor = interceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptor);
  }


}
