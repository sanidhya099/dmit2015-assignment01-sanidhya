package dmit2015.faces;

import dmit2015.restclient.Football;
import dmit2015.restclient.FootballMpRestClient;
import lombok.Getter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;


@Named("currentFootballListView")
@ViewScoped
public class FootballListView implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    @RestClient
    private FootballMpRestClient _$

    {
        jsonDataClass.toLowerCase()
    }

    MpRestClient;

    @Getter
    private Map<String, Football> $

    {
        jsonDataClass.toLowerCase()
    }

    Map;

    @PostConstruct  // After @Inject is complete
    public void init() {
        try {
            $ {
                DocumentName.toLowerCase()
            } Map = _$ {
                jsonDataClass.toLowerCase()
            } MpRestClient.findAll();
        } catch (Exception ex) {
            Messages.addGlobalError(ex.getMessage());
        }
    }
}