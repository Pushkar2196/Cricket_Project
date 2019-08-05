import com.company.DbConnection;
import com.company.DbImplement;

import java.util.ArrayList;
import java.util.List;

public class CricketGame {

    public static void  main(String[] args) {
        DbImplement dbImplement = new DbImplement();
        int noOfMatches = 2;

        String[] players1 = dbImplement.getPlayers("India");
        String[] playerTypes1 = dbImplement.getPlayerType("India");
        String[] players2 = dbImplement.getPlayers("Australia");
        String[] playerTypes2 = dbImplement.getPlayerType("Australia");

        Series series = new Series("Paytm Cup",noOfMatches);
        for(int i = 0 ; i < noOfMatches ; i++) {
            Team team1 = getTeam(players1,playerTypes1,"India");
            Team team2 = getTeam(players2,playerTypes2,"Australia");
            Match match = new Match(team1,team2,20);
            series.addMatch(match);
        }
        List<Match> matchSeries = series.getSeries();
        for(int i = 0 ; i < series.getSeries().size() ; i++) {
            System.out.println("\nMatch No: " +(i+1));
            MatchController controller = new MatchController(matchSeries.get(i));
            controller.run();
        }
        DbConnection.closeConnection();
    }

    private static Team getTeam(String[] players , String[] playerTypes , String Country ) {
        Team team = new Team(Country);
        for(int i = 0; i < 11 ; i++) {
            Player.PlayerType pType;
            switch (playerTypes[i]) {
                case "BATSMAN":
                    pType = Player.PlayerType.BATSMAN;
                    break;
                case "WICKETKEEPER":
                    pType = Player.PlayerType.WICKETKEEPER;
                    break;
                case "ALLROUNDER":
                    pType = Player.PlayerType.ALLROUNDER;
                    break;
                case "BOWLER":
                    pType = Player.PlayerType.BOWLER;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + playerTypes[i]);
            }
            Player player = new Player(players[i],30,Country, pType);
            team.addPlayer(player);
        }
        return team;
    }
}
