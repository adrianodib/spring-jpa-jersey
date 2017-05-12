package br.com.cinq.spring.data.sample.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/*")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(Controller.class);
    }
}
