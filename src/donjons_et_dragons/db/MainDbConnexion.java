package donjons_et_dragons.db;

import donjons_et_dragons.character.Character;

import java.util.List;
import static donjons_et_dragons.db.queryDb.fetchHeroes.getHeroes;

public class MainDbConnexion {

    protected static final String URL = "jdbc:mysql://localhost:3306/DnD";
    protected static final String USER = "root";
    protected static final String PASSWORD = "";
    public int id;

    // Test d'affichage des heros en BDD
    public static void main(String[] args) {
        List<Character> heroes = getHeroes();
        if (heroes.isEmpty()) {
            System.out.println("No heroes found.");
        } else {
            heroes.forEach(System.out::println);
        }
    }
}