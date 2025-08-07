package donjons_et_dragons;
import donjons_et_dragons.core.LaunchGame;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        LaunchGame newGame = new LaunchGame();
            newGame.main();
    }
}
