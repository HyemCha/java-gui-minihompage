package db;

import java.sql.*;

public class DBConnect {
    public final static String APP = "app";
    public final static String MINIHOMEPAGE = "minihomepage";
    static Connection con = null;
    static String user = "root";
    static String pass = "1234";

    public DBConnect(String DBName) {
        con = makeCon(DBName);
    }

    public static Connection makeCon(String DBName) {
        System.out.println("dfsdf::" + DBName);
        // TODO Auto-generated method stub
        String url = "jdbc:mysql://localhost:3306/" + DBName + "?serverTimezone=Asia/Seoul";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("헤이 아임히얼");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return con;
        }
    }

    public ResultSet select() {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql;

        sql = "select distinct day_num from schedule";
        try {
            ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public ResultSet select(String date) {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql;

        sql = "select * from schedule where day_num = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, date);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void insert(String date, String memo) {
        PreparedStatement ps;
        String sql = "insert into schedule values(null, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, memo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement ps;
        String sql = "delete from schedule where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        PreparedStatement ps;
        String sql = "delete * from schedule";
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
