import java.util.List;

class MatchController {
    private Team team1;
    private Team team2;
    private Match match;
    private String tossResult;

    public MatchController(Match match){
        team1 = match.getTeam1();
        team2 = match.getTeam2();
        this.match = match;
    }

    private void startFirstInningsGame() {
        if(tossResult.equals("00") || tossResult.equals("11")) {
            match.setTeams(team1,team2);
            match.firstInningsGame(team1,team2);
        }
        else{
            match.setTeams(team2,team1);
            match.firstInningsGame(team2,team1);
        }
    }

    private void startSecondInningsGame() {
        if(tossResult.equals("00") || tossResult.equals("11")) {
            match.setTeams(team1,team2);
            match.secondInningsGame(team1,team2);
        }
        else{
            match.setTeams(team2,team1);
            match.secondInningsGame(team2,team1);
        }
    }

    private void startToss(){
        match.toss();
        tossResult = match.getTossResult();
    }

    private void scoreBoard() {
        List<Player> players = team1.getPlayers();
        System.out.println("\nScoreboard\n");
        System.out.println(team1.getName()+":");
        System.out.println("****Batsman****");
        for (Player player : players) {
            System.out.println(player.getName()+" Runs: "+player.getRuns()+" Balls: "+player.getBalls()+" sixes: "+player.getSixes()+" fours: "+player.getFour());
        }
        System.out.println("****Bowlers****");
        players = team1.getBowlers();
        for (Player player : players) {
            System.out.println(player.getName() + " -  Runs: " + player.getRunsGiven() + " Balls: " + player.getBallsBowled()+" Wickets: "+player.getWickets());
        }
        players = team2.getPlayers();
        System.out.println("\n"+team2.getName()+":");
        System.out.println("****Batsman****");
        for (Player player : players) {
            System.out.println(player.getName()+" Runs: "+player.getRuns()+" Balls: "+player.getBalls()+" sixes: "+player.getSixes()+" fours: "+player.getFour());
        }
        System.out.println("****Bowlers****");
        players = team2.getBowlers();
        for (Player player : players) {
            System.out.println(player.getName()+" - Runs: "+player.getRunsGiven()+" Balls: "+player.getBallsBowled()+" Wickets: "+player.getWickets());
        }
    }

    private void result() {
        System.out.println("\nResult:");
        if(team1.getRuns() > team2.getRuns()) {
            System.out.println(team1.getName()+" has won the match\n");
        }
        else {
            System.out.println(team2.getName()+" has won the match\n");
        }
    }

    public void run() {
        startToss();
        startFirstInningsGame();
        startSecondInningsGame();
        scoreBoard();
        result();
    }

}
