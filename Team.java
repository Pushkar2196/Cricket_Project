import java.util.List;
import java.util.ArrayList;

public class Team {
    private String name;
    private List<Player> players;
    private String captain;
    private String viceCaptain;
    private int runs;
    private int wicket;
    private Player striker;
    private Player nonStriker;

    public Team(String name){
        this.name = name;
        players = new ArrayList<Player>();
        runs = 0;
        wicket = 0;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
    }
    public Player getStriker() {
        return striker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }

    public Player getNonStriker() {
        return nonStriker;
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
