
import java.util.*;
import java.lang.String;
class Match {
    private Team team1;
    private Team team2;
    private String tossResult;
    private String matchType;
    private int firstInningsScore;
    private int secondInningsScore;
    private int OVERS;
    private String winner;
    private String losser;

    public Match(Team team1, Team team2, int OVERS){
        this.team1 = team1;
        this.team2 = team2;
        matchType = "T20";
        firstInningsScore = 0;
        secondInningsScore = 0;
        this.OVERS = OVERS;
    }

    public void toss(){
        System.out.println();
        String[] toss_outcome = {"00","01","10","11"};
        Random rand = new Random();
        int random_number = rand.nextInt(4);
        tossResult = toss_outcome[random_number];
        switch (tossResult) {
            case "00":
                System.out.println(team1.getName()+" has won the toss and decided to Bat first");
                break;
            case "01":
                System.out.println(team1.getName()+" has won the toss and decided to ball first");
                break;
            case "10":
                System.out.println(team2.getName()+" has won the toss and decided to Bat first");
                break;
            case "11":
                System.out.println(team2.getName()+" has won the toss and decided to ball first");
                break;
        }
        System.out.println();
    }

    private void swapPlayers(Team team){
        Player temp = team.getStriker();
        team.setStriker(team.getNonStriker());
        team.setNonStriker(temp);
    }

    private void bringNewBatsman(Team team) {
        team.setStriker(team.getPlayers().get(team.getWicket() + 2));
    }

    private void setOpeners(Team team) {
        team.setStriker(team.getPlayers().get(0));
        team.setNonStriker(team.getPlayers().get(1));
    }

    private void addRunsByPlayer(Team team, int run) {
        team.getStriker().addRuns(run);
        if(run == 4) {
            team.getStriker().addFour();
        }
        else if(run == 6) {
            team.getStriker().addSixes();
        }
        if(run % 2 == 1) {
            swapPlayers(team);
        }
    }

    private void updateResult(Team team1, Team team2) {
        winner = team1.getName();
        losser = team2.getName();
    }

    private void setFirstInningsScore(Team team) {
        firstInningsScore = team.getRuns();
    }

    private void setSecondInningsScore(Team team) {
        secondInningsScore = team.getRuns();
    }

    private void printInningsScore(Team team) {
        System.out.println(team.getName()+": "+team.getRuns()+"/"+team.getWicket());
    }

    public void firstInningsGame(Team team){
        setOpeners(team);
        for(int i = 0 ; i < OVERS ; i++){
            System.out.print("Over no "+ i +": ");
            for(int j = 0 ; j < 6 ; j++){
                int run = runsPerBall(team.getStriker());
                team.getStriker().addBalls();
                if(run == 7){
                    if(team.getWicket() + 1 == 10){
                        team.out();
                        System.out.println("W ");
                        setFirstInningsScore(team);
                        printInningsScore(team);
                        return;
                    }
                    else{
                        bringNewBatsman(team);
                        team.out();
                        System.out.print("W ");
                    }
                }
                else{
                    System.out.print(run+" ");
                    team.addRuns(run);
                    addRunsByPlayer(team,run);
                }
            }
            swapPlayers(team);
            System.out.println();
        }
        setFirstInningsScore(team);
        printInningsScore(team);
    }

    public void secondInningsGame(Team team1, Team team2) {
        setOpeners(team2);
        System.out.println("\nInnings Break\n");
        for(int i = 0 ; i < OVERS ; i++){
            System.out.print("Over no "+ i +": ");
            for(int j = 0 ; j < 6 ; j++){
                team2.getStriker().addBalls();
                int run = runsPerBall(team2.getStriker());
                if(run == 7){
                    if(team2.getWicket() + 1 == 10){
                        team2.out();
                        System.out.println("W ");
                        setSecondInningsScore(team2);
                        printInningsScore(team2);
                        updateResult(team1,team2);
                        return;
                    }
                    else{
                        bringNewBatsman(team2);
                        team2.out();
                        System.out.print("W ");
                    }
                }
                else{
                    if(team2.getRuns() + run > team1.getRuns()) {
                        System.out.println(run+" ");
                        team2.addRuns(run);
                        addRunsByPlayer(team2,run);
                        setSecondInningsScore(team2);
                        printInningsScore(team2);
                        updateResult(team2,team1);
                        return;
                    }
                    else {
                        System.out.print(run+" ");
                        team2.addRuns(run);
                        addRunsByPlayer(team2,run);
                    }
                }
            }
            System.out.println();
        }
        printInningsScore(team2);
        setSecondInningsScore(team2);
        if(firstInningsScore == secondInningsScore) {
            System.out.println("Match is draw");
            return;
        }
        int runsRemaining = team1.getRuns() - team2.getRuns();
        System.out.println(team1.getName() + " won the match by " + runsRemaining + " runs");
        updateResult(team1,team2);
    }

    public int runsPerBall(Player player) {
        int[] batsmanFrequency = {1,1,1,1,1,1,2,2,2,2,3,3,3,4,4,6,6,7};//18
        int[] bowlerFrequency = {1,1,1,1,2,2,3,4,6,7};//10
        Random rand = new Random();
        if(player.getPlayerType() == Player.PlayerType.BATSMAN || player.getPlayerType() == Player.PlayerType.WICKETKEEPER) {
            return batsmanFrequency[rand.nextInt(18)];
        }
        else{
            return bowlerFrequency[rand.nextInt(10)];
        }
    }

    public String getTossResult() {
        return tossResult;
    }

    public int getFirstInningsScore() {
        return firstInningsScore;
    }

    public int getSecondInningsScore() {
        return secondInningsScore;
    }

    public String getWinner() {
        return winner;
    }

    public String getLosser() {
        return losser;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }
}

