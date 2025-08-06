package donjons_et_dragons.db;

import donjons_et_dragons.character.Character;
import donjons_et_dragons.character.Warrior;
import donjons_et_dragons.character.Wizard;
import donjons_et_dragons.core.Commands;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnexionDb {

    private static final String URL = "jdbc:mysql://localhost:3306/DnD";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Test d'affichage des héros en BDD
    public static void main(String[] args) {
        List<Character> heroes = getHeroes();
        if (heroes.isEmpty()) {
            System.out.println("No heroes found.");
        } else {
            heroes.forEach(System.out::println);
        }
    }

    public static List<Character> getHeroes() {
        List<Character> heroes = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM players");

            while (res.next()) {
                int id = res.getInt("id");
                String type = res.getString("type");
                String name = res.getString("name");
                int hp = res.getInt("hp");
                int str = res.getInt("str");
                String offensive = res.getString("offensiveEquipment");
                String defensive = res.getString("defensiveEquipment");

                Character hero;
                if ("wizard".equalsIgnoreCase(type)) {
                    hero = new Wizard(name, offensive);
                } else if ("warrior".equalsIgnoreCase(type)) {
                    hero = new Warrior(name, offensive);
                } else {
                    hero = new Character(id, type, name, hp, str, offensive, defensive);
                }
                hero.setHp(hp);
                hero.setStr(str);
                hero.setDefensiveEquipment(defensive);
                heroes.add(hero);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return heroes;
    }

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

    public static void editHero(int id, String newName) {
        String query = "UPDATE players SET name = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newName);


            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
