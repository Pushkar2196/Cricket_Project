import java.util.List;
import java.util.ArrayList;

public class Team {
    private String name;
    private List<Player> players;
    private String captain;
    private String viceCaptain;
    private int runs;
    private int wicket;

    public Team(String name, String captain, String viceCaptain){
        this.name = name;
        this.captain = captain;
        this.viceCaptain = viceCaptain;
        this.players = new ArrayList<Player>();
        this.runs = 0;
        this.wicket = 0;
    }

    public void addRuns(int run){
        runs +=run ;
    }

    public void out() {
        wicket++;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getCaptain() {
        return captain;
    }

    public String getViceCaptain() {
        return viceCaptain;
    }

    public int getRuns() {
        return runs;
    }

    public int getWicket() {
        return wicket;
    }
}
