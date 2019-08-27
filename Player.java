
class Player{
    private final String name;
    private int age;
    private String team;
    private int runs;
    private int balls;
    private int sixes;
    private int four;
    private int runsGiven;
    private int ballsBowled;
    private int wickets;
    private PlayerType playerType;

    public enum PlayerType {
        BATSMAN, BOWLER, WICKETKEEPER, ALLROUNDER
    }

    public Player(String name, int age, String team, PlayerType playerType) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.playerType = playerType;
        runs = 0;
        balls = 0;
        sixes = 0;
        four = 0;
        runsGiven = 0;
        ballsBowled = 0;
        wickets = 0;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public void addBalls() {
        balls += 1;
    }

    public void addFour() {
        four += 1;
    }

    public void addSixes() {
        sixes += 1;
    }

    public int getBalls() {
        return balls;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public int getRuns() {
        return runs;
    }

    public int getSixes() {
        return sixes;
    }

    public int getFour() {
        return four;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven += runsGiven;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }

    public void setBallsBowled() {
        ballsBowled += 1;
    }

    public int getWickets() {
        return wickets;
    }

    public void addWickets() {
        wickets += 1;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}