package app.trybe.specialityapp.config;

import app.trybe.specialityapp.SpecialityAppApplication;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


/**
 * The type Jersey config.
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

  private Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

  /**
   * Constructor para o JerseyConfig.
   *
   */
  public JerseyConfig() {
    packages(SpecialityAppApplication.class.getPackageName());
    register(new  AbstractBinder() {

      @Override
      protected void configure() {
        logger.info("Configurando binder");
      }
    });
  }
}
