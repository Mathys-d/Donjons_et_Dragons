package donjons_et_dragons.db.queryDb;

import donjons_et_dragons.character.Character;
import donjons_et_dragons.character.Warrior;
import donjons_et_dragons.character.Wizard;
import donjons_et_dragons.db.MainDbConnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class fetchHeroes extends MainDbConnexion {

    public static List<donjons_et_dragons.character.Character> getHeroes() {
        List<donjons_et_dragons.character.Character> heroes = new ArrayList<>();

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
                    hero = new Warrior("default","sword");
                }

                hero.setId(id);
                hero.setType(type);
                hero.setName(name);
                hero.setHp(hp);
                hero.setStr(str);
                hero.setOffensiveEquipment(offensive);
                heroes.add(hero);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return heroes;
    }
}

