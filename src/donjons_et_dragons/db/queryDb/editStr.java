package donjons_et_dragons.db.queryDb;

import donjons_et_dragons.db.MainDbConnexion;
import java.sql.*;

public class editStr extends MainDbConnexion {

    public static void changingWeapon(String name, int str, String offensiveEquipment) {
        String selectQuery = "SELECT id FROM players WHERE name = ?";
        String updateQuery = "UPDATE players SET str = ?, offensiveEquipment = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            // Recherche de l'ID
            selectStmt.setString(1, name);
            ResultSet res = selectStmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("id");

                // Mise à jour des données
                updateStmt.setInt(1, str);
                updateStmt.setString(2, offensiveEquipment);
                updateStmt.setInt(3, id);
                updateStmt.executeUpdate();

            } else {
                System.out.println("error no strength change");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
