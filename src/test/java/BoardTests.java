import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

    @Test
    public void isCellEmpty_positive() {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void isCellEmpty_negative() {
        Board board = new Board();
        board.place(0, 0, 'X');

        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void place_positive() {
        Board board = new Board();

        board.place(1, 1, 'X');

        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    void place_negative() {
        Board board = new Board();

        board.place(1, 1, 'X');
        board.place(1, 1, 'O');

        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    void isFull_positive() {
        Board board = new Board();

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board.place(r, c, 'X');
            }
        }

        assertTrue(board.isFull());
    }

    @Test
    void isFull_negative() {
        Board board = new Board();

        board.place(0, 0, 'X');

        assertFalse(board.isFull());
    }

    @Test
    void clear_positive() {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.clear();

        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void clear_negative() {
        Board board = new Board();

        board.place(0, 0, 'X');

        assertFalse(board.isCellEmpty(0, 0));
    }

















}
