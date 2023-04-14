package DAO;

import java.sql.*;;

public class connectmysql {
    private static String MYSQL_JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/bookstore";
    private static String MYSQL_DB_USER = "root";
    private static String MYSQL_DB_USER_PASSWORD = "";
    // private static String SQL_QUERY = "Select * from student";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_USER_PASSWORD)) {

            System.out.print("Thanh cong");

        } catch (SQLException e) {
            // System.out.println("Error occured while executing query: " + SQL_QUERY);
            e.printStackTrace();
        }
    }

}
