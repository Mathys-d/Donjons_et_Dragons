package donjons_et_dragons.db;

import java.sql.*;

public class ConnexionDb {

    public static void main(String[] args) throws SQLException {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/DnD", "root", "1234");

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM `players`");

            while(res.next()) {
                System.out.println(
                        res.getInt(1) + "  " +
                                res.getString(2) + "  " +
                                res.getString(3) + "  " +
                                res.getInt(4) + "  " +
                                res.getInt(5) + "  " +
                                res.getString(6) + "  " +
                                res.getString(7)
                );
            }
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void getHeroes(){
    }
}











