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
        String[] toss_outcome = {"00","01","10","11"};
        Random rand = new Random();
        int random_number = rand.nextInt(4);
        tossResult = toss_outcome[random_number];
        if(tossResult.charAt(0) == '0'){
            if(tossResult.charAt(1) == '0'){
                System.out.println(team1.getName()+" has won the toss and decided to Bat first");
            }
            else{
                System.out.println(team1.getName()+" has won the toss and decided to ball first");
            }
        }
        else{
            if(tossResult.charAt(1) == '0'){
                System.out.println(team2.getName()+" has won the toss and decided to Bat first");
            }
            else{
                System.out.println(team2.getName()+" has won the toss and decided to ball first");
            }
        }
    }

    public void firstInningsGame(Team team){
        List<Player> player = team.getPlayers();
        for(int i = 0 ; i < OVERS ; i++){
            System.out.print("Over no "+ i +": ");
            for(int j = 0 ; j < 6 ; j++){
                int run = runsPerBall();
                if(run == 7){
                    if(team.getWicket() + 1 == 10){
                        System.out.println("W ");
                        System.out.println(team.getName() + " is all out for " + team.getRuns()+" runs");
                        firstInningsScore = team.getRuns();
                        return;
                    }
                    else{
                        team.out();
                        System.out.print("W ");
                    }
                }
                else{
                    System.out.print(run+" ");
                    team.addRuns(run);
                    player.get(team.getWicket());
                }
            }
            System.out.println();
        }
        firstInningsScore = team.getRuns();
    }

    public void secondInningsGame(Team team1, Team team2) {
        System.out.println("\nInnings Break\n");
        for(int i = 0 ; i < OVERS ; i++){
            System.out.print("Over no "+ i +": ");
            for(int j = 0 ; j < 6 ; j++){
                int run = runsPerBall();
                if(run == 7){
                    if(team2.getWicket() + 1 == 10){
                        System.out.println("W ");
                        System.out.println(team2.getName() + " is all out for " + team2.getRuns()+" runs");
                        secondInningsScore = team2.getRuns();
                        winner = team1.getName();
                        losser = team2.getName();
                        return;
                    }
                    else{
                        team2.out();
                        System.out.print("W ");
                    }
                }
                else{
                    if(team2.getRuns() + run > team1.getRuns()) {
                        System.out.println(team2.getWicket());
                        int wicketLeft = 10 - team2.getWicket();
                        System.out.println(team2.getName() + " won the match by " + wicketLeft +" wickets");
                        secondInningsScore = team2.getRuns();
                        winner = team2.getName();
                        losser = team1.getName();
                        return;
                    }
                    else{
                        team2.addRuns(run);
                        System.out.print(run+" ");
                    }
                }
            }
            System.out.println();
            if(i + 1 == OVERS) {
                int runsRemaining = team1.getRuns() - team2.getRuns();
                // System.out.println(team1.getRuns()+" "+team2.getRuns());
                System.out.println(team1.getName() + " won the match by " + runsRemaining + " runs");
                secondInningsScore = team2.getRuns();
                winner = team1.getName();
                losser = team2.getName();
                return;
            }
        }
    }

    public int runsPerBall(){
        Random rand = new Random();
        return rand.nextInt(8);
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
}
