import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(new File(args[0]));
            int fieldNumber = 1;
            int height = Integer.parseInt(scanner.next());
            int width = Integer.parseInt(scanner.next());

            do {
                scanner.nextLine();
                final Minesweeper minesweeper = new Minesweeper(height, width,
                    createMatrixFromInput(scanner, height, width));
                minesweeper.createHintField();

                System.out.println("Field #" + fieldNumber++ + ":");
                System.out.println(minesweeper);

                height = Integer.parseInt(scanner.next());
                width = Integer.parseInt(scanner.next());
            } while (!(height == 0 && width == 0));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        }

    }

    private static String[][] createMatrixFromInput(Scanner scanner, int height, int width) {
        String[][] field = new String[height][width];
        for (int i = 0; i < height; i++) {
            final String s = scanner.nextLine();
            for (int j = 0; j < width; j++) {
                field[i][j] = String.valueOf(s.charAt(j));
            }
        }
        return field;
    }
}
