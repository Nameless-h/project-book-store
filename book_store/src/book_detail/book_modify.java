/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book_detail;

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
public class book_modify {
    public static ArrayList<book> allBook() throws Exception {
        ArrayList<book> bookList = new ArrayList<book>();

        java.sql.Connection conn = null;
        Statement statement = null;
        try {
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mySQL://localhost:3306/test", "root", "otakus.a.o711");

            String sql = "SELECT * FROM Book";
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                book b1 = new book(result.getInt("maSach"),
                        result.getString("tenSach"),
                        result.getInt("maTacgia"),
                        result.getInt("maTheloai"),
                        result.getInt("maNXB"),
                        result.getString("namXB"),
                        result.getInt("soLuong"),
                        result.getInt("giaTien"));

                bookList.add(b1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return bookList;
    }

    public static void addBook() {

    }

    public static void editBook(book bk_id) {

    }

    public static void delBook(book bk_id) {

    }

    public static book getbook(int maBook) {
        Connection conn = null;
        PreparedStatement statement = null;
        book tmp = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "otakus.a.o711");
            statement = conn.prepareStatement("SELECT * FROM book WHERE maSach = (?)");
            statement.setInt(1, maBook);
            ResultSet result = statement.executeQuery();
            result.next();
            tmp = new book(result.getInt("maSach"),
                    result.getString("tenSach"),
                    result.getInt("maTacgia"),
                    result.getInt("maTheloai"),
                    result.getInt("maNXB"),
                    result.getString("namXB"),
                    result.getInt("soLuong"),
                    result.getInt("giaTien"));
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

    public static void main(String[] args) throws Exception {
        // book_modify.allBook();
    }
}
