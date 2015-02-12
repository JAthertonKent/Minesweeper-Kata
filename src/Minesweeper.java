public class Minesweeper {
    private final int height;
    private final int width;
    private String[][] bombField;

    public Minesweeper(int n, int m, String[][] bombField) {
        this.height = n;
        this.width = m;
        this.bombField = bombField;
    }

    public String[][] createHintField() {
        replaceDotWithZeros();
        incrementCells();

        return bombField;
    }

    private void incrementCells() {
        for (int i = 0; i < bombField.length; i++) {
            for (int j = 0; j < bombField[i].length; j++) {

                if (bombField[i][j].equals("*")) {
                    incrementNeighborCell(i, j+1);
                    incrementNeighborCell(i, j-1);
                    incrementNeighborCell(i-1, j);
                    incrementNeighborCell(i+1, j);
                    incrementNeighborCell(i+1, j+1);
                    incrementNeighborCell(i+1, j-1);
                    incrementNeighborCell(i-1, j+1);
                    incrementNeighborCell(i-1, j-1);
                }
            }
        }
    }

    private void incrementNeighborCell(int i, int j) {
        if (exists(i, j) && notABomb(i, j)) {
            Integer f = Integer.parseInt(bombField[i][j]) + 1;
            bombField[i][j] = f.toString();
        }
    }

    private boolean notABomb(int i, int j) {
        return !bombField[i][j].equals("*");
    }

    private boolean exists(int i, int j) {
        return i >= 0 && i < height && j >= 0 && j < width;
    }

    private void replaceDotWithZeros() {
        for (int i = 0; i < bombField.length; i++) {
            for (int j = 0; j < bombField[i].length; j++) {
                bombField[i][j] = bombField[i][j].replace(".","0");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bombField.length; i++) {
            for (int j = 0; j < bombField[i].length; j++) {
                builder.append(bombField[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
