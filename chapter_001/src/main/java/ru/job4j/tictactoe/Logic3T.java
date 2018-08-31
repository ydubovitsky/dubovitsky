package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean winner = false;
        boolean x = table[0][0].hasMarkX() ? true : false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (x != table[i][j].hasMarkX()) {
                    winner = false;
                    break;
                } else {
                    winner = false;
                    break;
                }
            }
            if (winner = true) {
                break;
            }
        }
        return winner;
    }

    public boolean isWinnerO() {
        return false;
    }

    public boolean hasGap() {
        return true;
    }
}

