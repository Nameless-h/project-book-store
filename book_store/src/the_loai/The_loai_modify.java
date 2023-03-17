/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package the_loai;

import book_detail.book_modify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JN_PC
 */
public class The_loai_modify {
    public static ArrayList<Theloai> allCate() {
        ArrayList<Theloai> cate = new ArrayList<Theloai>();

        java.sql.Connection conn = null;
        Statement statement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mySQL://localhost:3306/test", "root", "otakus.a.o711");
            statement = conn.createStatement();
            String sql = "SELECT * FROM theloai";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Theloai tl = new Theloai(result.getInt("maTheloai"),
                        result.getString("tenTheloai"));
                cate.add(tl);
            }
        } catch (SQLException e) {
            Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

        return cate;
    }

    public static Theloai getTheloai(int maTheloai) {
        Connection conn = null;
        PreparedStatement statement = null;
        Theloai tmp = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "otakus.a.o711");
            statement = conn.prepareStatement("SELECT * FROM theloai WHERE maTheloai = (?)");
            statement.setInt(1, maTheloai);
            ResultSet result = statement.executeQuery();
            result.next();
            tmp = new Theloai(result.getInt("maTheloai"),
                    result.getString("tenTheloai"));
        } catch (SQLException e) {
            // TODO: handle exception
            Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO: handle exception
                    Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return tmp;

    }

    public static void main(String[] args) {
        // System.out.println(getTheloai(1).getTenTheloai());
    }

}
