package donjons_et_dragons.board;

import donjons_et_dragons.ui.Menu;

import java.util.Random;

/**
 * Classe qui crée et initialise le tableau de jeu.
 */
public class Board {
    protected Cell[] cells;
    private Random rand = new Random();

    /**
     * Constructeur.
     * @param size taille du tableau
     */
    public Board(int size) {
        cells = new Cell[size];
    }

    /**
     * Génère cellule par cellule et ajoute seulement un élément dans une case.
     * @return tableau de cellules
     */
    public Cell[] generateBoard(){
        for (int i = 0; i < cells.length; i++) {
            int r = rand.nextInt(11) +1;
            if (r == 1) {
                cells[i] = new Cell(true, false,false,false,false);
            } else if (r == 2) {
                cells[i] = new Cell(false, true,false,false,false);
            } else if (r == 3) {
                cells[i] = new Cell(false, false,true,false,false);
            }else if (r == 4) {
                cells[i] = new Cell(false, false,false,true,false);
            }else if (r == 5) {
                cells[i] = new Cell(false, false,false,false,true);
            } else {
                cells[i] = new Cell(false, false,false,false,false);
            }
        }
        return cells;
    }
}
