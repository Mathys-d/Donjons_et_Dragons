package donjons_et_dragons.db.queryDb;

import donjons_et_dragons.character.Character;
import donjons_et_dragons.db.MainDbConnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertHeroDbConnexion extends MainDbConnexion {

    public void createHero(Character hero) throws SQLException {
        String query = "INSERT INTO players(type, name, hp, str, offensiveEquipment, defensiveEquipment) VALUES( ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hero.getType());
            stmt.setString(2, hero.getName());
            stmt.setInt(3, hero.getHp());
            stmt.setInt(4, hero.getStr());
            stmt.setString(5, hero.getOffensiveEquipment());
            stmt.setString(6, hero.getDefensiveEquipment());

            stmt.executeUpdate();
        }
    }
}
