package donjons_et_dragons.db.queryDb;

import donjons_et_dragons.db.MainDbConnexion;

import java.sql.*;

public class editNameDbConnexion extends MainDbConnexion {

    public static void editHero(String changingName, String newName) {
        String selectQuery = "SELECT id FROM players WHERE name = ?";
        String updateQuery = "UPDATE players SET name = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            System.out.println("Searching for: " + changingName);
            selectStmt.setString(1, changingName);
            ResultSet res = selectStmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("id");

                updateStmt.setString(1, newName);
                updateStmt.setInt(2, id);
                updateStmt.executeUpdate();

                System.out.println("name changed at " + changingName + " with " + newName);
            } else {
                System.out.println("There is no character with this name : " + changingName);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
