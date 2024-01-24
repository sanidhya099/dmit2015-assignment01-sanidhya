package dmit2015.faces;

import dmit2015.restclient.Football;
import dmit2015.restclient.FootballMpRestClient;

import jakarta.json.JsonObject;
import lombok.Getter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.omnifaces.util.Messages;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("currentFootballCreateView")
@RequestScoped
public class FootballCreateView {

    @Inject
    @RestClient
    private FootballMpRestClient _footballMpRestClient;

    @Getter
    private Football newFootball = new Football();

    public String onCreateNew() {
        String nextPage = null;
        try {
            JsonObject responseBody = _footballMpRestClient.create(newFootball);
            String documentKey = responseBody.getString("name");
            newFootball = new Football();
            Messages.addFlashGlobalInfo("Create was successful. {0}", documentKey);
            nextPage = "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addGlobalError("Create was not successful. {0}", e.getMessage());
        }
        return nextPage;
    }


}