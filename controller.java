package controller;

import Connection.connectWithDatabase;

import java.sql.*;
import java.util.ArrayList;

public class controller {

    //seach tu
    public static String findWord(String text) throws SQLException {
        text  = text.toLowerCase();
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        Statement stmt = conn.createStatement();
        String sql = "select detail from dictionary where word = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, text);
            ResultSet rs = pstm.executeQuery();
            String Detail = "";
            while (rs.next()) {
                Detail = rs.getString("detail");
            }
            rs.close();
            stmt.close();
            conn.close();
            return Detail;
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }

    //Goi y
    public static String[] suggestionWord(String text) throws SQLException {
        ArrayList<String> list = new ArrayList<String>();
        text  = text.toLowerCase();
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        String sql = "select word from dictionary where word like ? limit ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, text + "%");
            pstm.setInt(2, 50);

            ResultSet rs = pstm.executeQuery();
            int i = 0;
            while (rs.next()) {
                String test = rs.getString("word");
                if (test != null) {
                    list.add(test);
                } else {
                    break;
                }
                i++;
            }
            int k = 0;
            int length = list.size();
            String[] result = new String[length];
            for (k = 0; k < i; k++) {
                result[k] = list.get(k);
            }
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void addWordToDatabase(String word, String detail) {
        word  = word.toLowerCase();
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        String sql = "insert into dictionary values(?, ?)";
        try {

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, word);
            pstm.setString(2, detail);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletaWordFromDatabase(String word){
        word  = word.toLowerCase();
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        String sql = "delete from dictionary where word = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, word);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
