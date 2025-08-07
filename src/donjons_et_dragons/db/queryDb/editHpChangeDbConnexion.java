package donjons_et_dragons.db.queryDb;

import donjons_et_dragons.db.MainDbConnexion;

import java.sql.*;

public class editHpChangeDbConnexion extends MainDbConnexion {

    public static void changingHp(String name, int hp){
        String selectQuery = "SELECT id FROM players WHERE name = ?";
        String updateQuery = "UPDATE players SET hp = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            selectStmt.setString(1, name);
            ResultSet res = selectStmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("id");

                updateStmt.setInt(1, hp);
                updateStmt.setInt(2, id);
                updateStmt.executeUpdate();

            } else {
                System.out.println("error no health change");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
