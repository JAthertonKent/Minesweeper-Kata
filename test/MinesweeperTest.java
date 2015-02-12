import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MinesweeperTest {

    @Test
    public void simpleFieldWithNoBombs() {
        final String[][] bombField = {{"."}};
        final Minesweeper minesweeper = new Minesweeper(1, 1, bombField);

        String[][] hindField = minesweeper.createHintField();
        final String[][] expected = {{"0"}};
        assertThat(hindField, is(expected));
    }

    @Test
    public void simpleFieldWithOneBomb() {
        final String[][] bombField = {{"*", "."}};
        final Minesweeper minesweeper = new Minesweeper(1, 2, bombField);

        String[][] hindField = minesweeper.createHintField();
        final String[][] expected = {{"*", "1"}};
        assertThat(hindField, is(expected));
    }

    @Test
    public void simpleFieldWithTwoBombs() {
        final String[][] bombField = {{".", "*", ".", "*"}};
        final Minesweeper minesweeper = new Minesweeper(1, 4, bombField);

        String[][] hindField = minesweeper.createHintField();
        final String[][] expected = {{"1", "*", "2", "*"}};
        assertThat(hindField, is(expected));
    }

    @Test
    public void simpleFieldWithTwoBombsNextToEachOther() {
        final String[][] bombField = {{".", "*", "*", "."}};
        final Minesweeper minesweeper = new Minesweeper(1, 4, bombField);

        String[][] hindField = minesweeper.createHintField();
        final String[][] expected = {{"1", "*", "*", "1"}};
        assertThat(hindField, is(expected));
    }

    @Test
    public void fieldWithTwoRows() {
        final String[][] bombField = {{".", "*"},
                                      {".", "."}};
        final Minesweeper minesweeper = new Minesweeper(2, 2, bombField);

        String[][] hindField = minesweeper.createHintField();
        final String[][] expected = {{"1", "*"},
                                     {"1", "1"}};
        assertThat(hindField, is(expected));
    }

    @Test
    public void fieldWithThreeRows() {
        final String[][] bombField = {{".", "*", "."},
                                      {".", ".", "."},
                                      {"*", ".", "."}};
        final Minesweeper minesweeper = new Minesweeper(3, 3, bombField);

        String[][] hindField = minesweeper.createHintField();
        final String[][] expected = {{"1", "*", "1"},
                                     {"2", "2", "1"},
                                     {"*", "1", "0"}};
        assertThat(hindField, is(expected));
    }

    @Test
    public void shouldPrint() {
        final String[][] bombField = {{".", "*", "."},
            {".", ".", "."},
            {"*", ".", "."}};
        final Minesweeper minesweeper = new Minesweeper(3, 3, bombField);
        minesweeper.createHintField();
        assertThat(minesweeper.toString(), is("1*1\n221\n*10\n"));
    }
}