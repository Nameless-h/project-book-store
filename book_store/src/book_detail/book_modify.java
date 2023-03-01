/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book_detail;

import java.sql.DriverManager;
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
     public static ArrayList<book> allBook() throws Exception{
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
            while(result.next()){
                book b1 = new book( result.getInt("maSach"),
                                    result.getString("tenSach"),
                                    result.getInt("maTacgia"),
                                    result.getInt("maTheloai"),
                                    result.getInt("maNXB"), 
                                    result.getString("namXB"),
                                    result.getInt("soLuong"), 
                                    result.getInt("giaTien"));
                
                bookList.add(b1);
            }
            for(book a: bookList){
                System.out.println(a.getTensach());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return bookList;
    }
    
    public static void addBook(){
        System.out.println("book_detail.book_modify.addBook()");
    }
    public static void editBook(book bk_id){
        
    }
    public static void delBook(book bk_id){
        
    }
    
    
    public static void main(String[] args) throws Exception{
        book_modify.allBook();
    }
}
