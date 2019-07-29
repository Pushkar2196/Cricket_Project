
class MatchController {
    private Team team1;
    private Team team2;
    private Match match;
    private String tossResult;

    MatchController(Team team1, Team team2, Match match){
        this.team1 = team1;
        this.team2 = team2;
        this.match = match;
    }

    private void startFirstInningsGame() {
        if(tossResult.equals("00") || tossResult.equals("11")) {
            match.firstInningsGame(team1);
        }
        else{
            match.firstInningsGame(team2);
        }
    }

    private void startSecondInningsGame() {
        if(tossResult.equals("00") || tossResult.equals("11")) {
            match.secondInningsGame(team1,team2);
        }
        else{
            match.secondInningsGame(team2,team1);
        }
    }



    private void startToss(){
        match.toss();
        tossResult = match.getTossResult();
    }

    private void result() {

    }

    public void run() {
        startToss();
        startFirstInningsGame();
        startSecondInningsGame();
        result();
    }

}
