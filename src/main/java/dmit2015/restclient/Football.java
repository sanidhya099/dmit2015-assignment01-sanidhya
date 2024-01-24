package dmit2015.restclient;
import jakarta.validation.constraints.NotBlank;
import net.datafaker.providers.base.Team;


public class Football {
    // Define data fields for storing data

    private String Team;

    private String Player;

    private String Coach;
    // Create Getters/Setters to encapsulate access to data fields


    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public String getPlayer() {
        return Player;
    }

    public void setPlayer(String player) {
        Player = player;
    }

    public String getCoach() {
        return Coach;
    }

    public void setCoach(String coach) {
        Coach = coach;
    }
}