package com.trybe.spring.config;

import com.trybe.spring.application.BookController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(BookController.class);
  }

}
