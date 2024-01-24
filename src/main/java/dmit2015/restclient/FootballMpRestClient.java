package dmit2015.restclient;

import jakarta.enterprise.context.Dependent;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.LinkedHashMap;

/**
 * The baseUri for the web MpRestClient be set in either microprofile-config.properties (recommended)
 * or in this file using @RegisterRestClient(baseUri = "http://server/path").
 * <p>
 * To set the baseUri in microprofile-config.properties:
 * 1) Open src/main/resources/META-INF/microprofile-config.properties
 * 2) Add a key/value pair in the following format:
 * package-name.ClassName/mp-rest/url=baseUri
 * For example:
 * package-name:    dmit2015.restclient
 * ClassName:       FootballMpRestClient
 * baseUri:         http://localhost:8080/contextName
 * The key/value pair you need to add is:
 * <code>
 * dmit2015.restclient.FootballMpRestClient/mp-rest/url=http://localhost:8080/contextName
 * </code>
 * <p>
 * To use the client interface from an environment does support CDI, add @Inject and @RestClient before the field declaration such as:
 * <code>
 *
 * @Inject
 * @RestClient private FootballMpRestClient _footballMpRestClient;
 * </code>
 * <p>
 * To use the client interface from an environment that does not support CDI, you can use the RestClientBuilder class to programmatically build an instance as follows:
 * <code>
 * URI apiURI = new URI("http://sever/contextName");
 * FootballMpRestClient _footballMpRestClient = RestClientBuilder.newBuilder().baseUri(apiURi).build(FootballMpRestClient.class);
 * </code>
 */
@Dependent
@RegisterRestClient(baseUri = "https://dmit2015-sanidhya-default-rtdb.firebaseio.com")
public interface FootballMpRestClient {

    String DOCUMENT_URL = "/football";

    @POST
    @Path(DOCUMENT_URL + ".json")
    JsonObject create(Football newFootball);

    @GET
    @Path(DOCUMENT_URL + ".json")
    LinkedHashMap<String, Football> findAll();

    @GET
    @Path(DOCUMENT_URL + "/{key}.json")
    Football findById(@PathParam("key") String key);

    @PUT
    @Path(DOCUMENT_URL + "/{key}.json")
    Football update(@PathParam("key") String key, Football updatedFootball);

    @DELETE
    @Path(DOCUMENT_URL + "/{key}.json")
    void delete(@PathParam("key") String key);

}