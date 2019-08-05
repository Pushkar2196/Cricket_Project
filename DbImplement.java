package com.company;
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
}
