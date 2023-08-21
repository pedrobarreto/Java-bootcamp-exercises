package com.trybe.acc.java.iocdi.sistemapagamentos.configuration;

import com.trybe.acc.java.iocdi.sistemapagamentos.service.AuthConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Config.
 */
@Configuration
public class Config {
  /**
   * Auth config service auth config service.
   *
   * @return the auth config service
   */
  @Bean
  public AuthConfigService authConfigService() {
    return new AuthConfigService();
  }
}
