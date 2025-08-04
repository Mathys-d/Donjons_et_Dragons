package donjons_et_dragons.board;

import donjons_et_dragons.ui.Menu;

import java.util.Random;

public class Board {
    protected Cell[] cells;
    protected int newCase = 0;
    private Random rand = new Random();

    public Board(int size) {
        cells = new Cell[size];
    }

    public Cell[] generateBoard(){
        for (int i = 0; i < cells.length; i++) {
            int r = rand.nextInt(4) +1;
            if (r == 1) {
                cells[i] = new Cell(true, false,false);
            } else if (r == 2) {
                cells[i] = new Cell(false, true,false);
            } else if (r == 3) {
                cells[i] = new Cell(false, false,true);
            } else {
                cells[i] = new Cell(false, false,false);
            }
        }
        return cells;
    }

}