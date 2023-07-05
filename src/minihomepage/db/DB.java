package minihomepage.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    static Connection con = null;
    public String DBName;

    public DB(String DBName, Connection con) {
        this.DBName = DBName;
        this.con = con;
    }

    // get user profile
    public ResultSet selectUser() {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql;

        sql = "select * from user";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    // home
    public ResultSet selectHome() {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql;

        sql = "select * from user";
        try {
            ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    // diary
    public ResultSet selectDiary() {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql;

        sql = "select * from diary";
        try {
            ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    // guest book
    public ResultSet selectGuestBook() {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql;

        sql = "select * from guest_book";
        try {
            ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
}
