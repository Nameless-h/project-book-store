package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;


public class get_game_sold {
    

    public get_game_sold() {
        ArrayList listGameSold = new ArrayList<>();

        Connection conn = JDBCUtil.getConnection();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            String sql = "SELECT * FROM nxb";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                NXB tmp = new NXB(result.getInt("maNXB"),
                    result.getString("tenNXB"),
                    result.getString("email"),
                    result.getString("diaChi"),
                    result.getString("sdt"));

                listGameSold.add(tmp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
