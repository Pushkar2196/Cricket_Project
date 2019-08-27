
import java.sql.*;

public class DbImplement {
    private Connection connection = null;

    public String[] getPlayers(String country){
        String[] result = new String[11];
        int pointer = 0;
        String query = "select name from player where country = \'"+country+"\';";
        connection = DbConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                String s = rs.getString("name");
                result[pointer++] = s;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public String[] getPlayerType(String country) {
        String[] result = new String[11];
        int pointer = 0;
        String query = "select type from player where country = \'"+country+"\';";
        connection = DbConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                String s = rs.getString("type");
                result[pointer++] = s;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /*
  id               | int(11)      | NO   | PRI | NULL    | auto_increment |
| team1            | varchar(100) | YES  |     | NULL    |                |
| team2            | varchar(100) | YES  |     | NULL    |                |
| innings_no       | int(11)      | YES  |     | NULL    |                |
| over_no          | int(11)      | YES  |     | NULL    |                |
| first_inn_score  | int(11)      | YES  |     | NULL    |                |
| target           | int(11)      | YES  |     | NULL    |                |
| second_inn_score | int(11)      | YES  |     | NULL    |                |
| striker          | varchar(100) | YES  |     | NULL    |                |
| non_striker      | varchar(100) | YES  |     | NULL    |                |
| current_bowler   | varchar(100) | YES  |     | NULL    |                |
    */
    public void updateScore(Match match, int inningsNo, int overNo) {
        String team1Name = match.getTeam1().getName();
        String team2Name = match.getTeam2().getName();
        int firstInnScore = match.getTeam1().getRuns();
        int secondInnScore = 0;
        int target = 0;
        String striker, nonStriker, currentBowler;
        if(inningsNo == 1) {
            striker = match.getTeam1().getStriker().getName();
            nonStriker = match.getTeam1().getNonStriker().getName();
            currentBowler = match.getTeam2().getCurrentBowler().getName();
        }
        else {
            secondInnScore = match.getTeam2().getRuns();
            striker = match.getTeam2().getStriker().getName();
            nonStriker = match.getTeam2().getNonStriker().getName();
            currentBowler = match.getTeam1().getCurrentBowler().getName();
        }
        if(inningsNo == 1 && overNo == 19 || inningsNo == 2) {
            target = match.getTeam1().getRuns();
        }
        //System.out.println(team1Name+" "+team2Name+" "+inningsNo+" "+overNo+" "+firstInnScore+" "+" "+target+" "+striker+" "+nonStriker+" "+currentBowler);
        String query = "INSERT INTO score (team1, team2, innings_no, over_no, first_inn_score, target, second_inn_score, striker, non_striker, current_bowler) VALUES (\'"+team1Name+"\',\'"+team2Name+
                "\',\'"+inningsNo+"\',\'"+overNo+"\',\'"+firstInnScore+"\',\'"+target+"\',"+secondInnScore+",\'"+striker+"\',\'"+nonStriker+"\',\'"+currentBowler+"\');";
        connection = DbConnection.getConnection();
        try
        {
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
