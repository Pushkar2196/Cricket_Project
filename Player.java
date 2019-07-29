class Player{
    private final String name;
    private int age;
    private String team;
    private int runs;
    private int balls;
    private int sixes;
    private int four;
    private PlayerType playerType;

    public static enum PlayerType {
        BATSMAN, BOWLER, WICKETKEEPER, ALLROUNDER
    }

    public Player(String name, int age, String team, PlayerType playerType) {
        this.name = name;
		this.age = age;
        this.team = team;
        this.playerType = playerType;
		int runs = 0;
		int balls = 0;
		int sixes = 0;
		int four = 0;
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

    public PlayerType getPlayerType() {
        return playerType;
    }
}