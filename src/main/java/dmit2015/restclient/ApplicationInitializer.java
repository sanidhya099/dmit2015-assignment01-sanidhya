package dmit2015.restclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class ApplicationInitializer {
    private final Logger _logger = Logger.getLogger(ApplicationInitializer.class.getName());

    public void initialize(@Observes @Initialized(ApplicationScoped.class) Object event) {
        _logger.info("Preloading data");

        try {


        } catch (Exception ex) {
            _logger.log(Level.FINE, ex.getMessage(), ex);
        }

    }
}