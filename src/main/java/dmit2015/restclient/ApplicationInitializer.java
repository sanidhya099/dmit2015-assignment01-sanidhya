package dmit2015.restclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import net.datafaker.Faker;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class ApplicationInitializer {
    private final Logger _logger = Logger.getLogger(ApplicationInitializer.class.getName());

    @Inject
    @RestClient
    private FootballMpRestClient _footRestClient;

    public void initialize(@Observes @Initialized(ApplicationScoped.class) Object event) {
        _logger.info("Preloading data");

        try {
            // Create a new Faker instance
            var faker = new Faker();
            var Footballs = _footRestClient.findAll();
            if ( Footballs == null || Footballs.isEmpty()) {
                // Create 50 random VideoGames
                for (int count = 1; count <= 20; count++) {
                    // Create a new VideoGame instance
                    var newGame = new Football();
                    // Generate a title, genre, and platform for the newGame
                    newGame.setTeam(faker.football().teams());
                    newGame.setPlayer(faker.football().players());
                    newGame.setCoach(faker.football().coaches());
                    // Post the newGame to the REST API endpoints for Firebase Realtime DB
                    _footRestClient.create(newGame);
                }
            } else {
                if (Footballs.size() >= 50) {
                    for (var currentKey : Footballs.keySet()) {
                        _footRestClient.delete(currentKey);
                    }
                }
            }

        } catch (Exception ex) {
            _logger.log(Level.FINE, ex.getMessage(), ex);
        }

    }
}