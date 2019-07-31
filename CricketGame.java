import java.util.ArrayList;
import java.util.List;

public class CricketGame {
    public static void  main(String[] args) {
        Player player11 = new Player("Virat Kohli",30, "India", Player.PlayerType.BATSMAN);
        Player player12 = new Player("Rohit Sharma",30, "India", Player.PlayerType.BATSMAN);
        Player player13 = new Player("Shikhar Dhawan",30, "India", Player.PlayerType.BATSMAN);
        Player player14 = new Player("KL Rahul",30, "India", Player.PlayerType.BATSMAN);
        Player player15 = new Player("MS Dhoni",30, "India", Player.PlayerType.WICKETKEEPER);
        Player player16 = new Player("Hardik Pandya",30, "India", Player.PlayerType.ALLROUNDER);
        Player player17 = new Player("Kedhar Jadhav",30, "India", Player.PlayerType.ALLROUNDER);
        Player player18 = new Player("Chahal",30, "India", Player.PlayerType.BOWLER);
        Player player19 = new Player("kuldeep Yadav",30, "India", Player.PlayerType.BOWLER);
        Player player110 = new Player("Bhuvneshwar kumar",30, "India", Player.PlayerType.BOWLER);
        Player player111 = new Player("Bhumrah",30, "India", Player.PlayerType.BOWLER);

        Team team1 = new Team("India", "Virat Kohli", "Rohit Sharma");

        team1.addPlayer(player11);
        team1.addPlayer(player12);
        team1.addPlayer(player13);
        team1.addPlayer(player14);
        team1.addPlayer(player15);
        team1.addPlayer(player16);
        team1.addPlayer(player17);
        team1.addPlayer(player18);
        team1.addPlayer(player19);
        team1.addPlayer(player110);
        team1.addPlayer(player111);

        Player player21 = new Player("Aaron Finch",30, "Australia", Player.PlayerType.BATSMAN);
        Player player22 = new Player("David Warner",30, "Australia", Player.PlayerType.BATSMAN);
        Player player23 = new Player("Steve Smith",30, "Australia", Player.PlayerType.BATSMAN);
        Player player24 = new Player("Peter Handscomb",30, "Australia", Player.PlayerType.BATSMAN);
        Player player25 = new Player("Alex Carey",30, "Australia", Player.PlayerType.WICKETKEEPER);
        Player player26 = new Player("Marcus Stoinis",30, "Australia", Player.PlayerType.ALLROUNDER);
        Player player27 = new Player("Glenn Maxwell",30, "Australia", Player.PlayerType.ALLROUNDER);
        Player player28 = new Player("Pat Cummins",30, "Australia", Player.PlayerType.BOWLER);
        Player player29 = new Player("Mitchell Starc",30, "Australia", Player.PlayerType.BOWLER);
        Player player210 = new Player("Jason Behrendorff",30, "Australia", Player.PlayerType.BOWLER);
        Player player211 = new Player("Nathan Lyon",30, "Australia", Player.PlayerType.BOWLER);

        Team team2 = new Team("Australia", "Aaron Finch", "David Warner");

        team2.addPlayer(player21);
        team2.addPlayer(player22);
        team2.addPlayer(player23);
        team2.addPlayer(player24);
        team2.addPlayer(player25);
        team2.addPlayer(player26);
        team2.addPlayer(player27);
        team2.addPlayer(player28);
        team2.addPlayer(player29);
        team2.addPlayer(player210);
        team2.addPlayer(player211);

        Match match = new Match(team1,team2,20);
        MatchController controller = new MatchController(team1,team2,match);
        controller.run();
    }
}
