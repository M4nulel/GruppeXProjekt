import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    void hasWinnerPositiveRow() throws Exception {
        TicTacToe game = new TicTacToe();

        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board board = (Board) boardField.get(game);

        board.place(0,0,'X');
        board.place(0,1,'X');
        board.place(0,2,'X');

        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinnerNegative() throws Exception {
        TicTacToe game = new TicTacToe();

        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board board = (Board) boardField.get(game);

        board.place(0,0,'X');
        board.place(1,1,'O');
        board.place(2,2,'X');

        assertFalse(game.hasWinner());
    }

    @Test
    void switchCurrentPlayerPositive() throws Exception {
        TicTacToe game = new TicTacToe();

        Field currentPlayerField =
                TicTacToe.class.getDeclaredField("currentPlayer");
        currentPlayerField.setAccessible(true);

        Player before = (Player) currentPlayerField.get(game);

        game.switchCurrentPlayer();

        Player after = (Player) currentPlayerField.get(game);

        assertNotEquals(before.getMarker(), after.getMarker());
    }

    @Test
    void switchCurrentPlayerNegative() throws Exception {
        TicTacToe game = new TicTacToe();

        Field currentPlayerField =
                TicTacToe.class.getDeclaredField("currentPlayer");
        currentPlayerField.setAccessible(true);

        Player before = (Player) currentPlayerField.get(game);

        assertEquals('X', before.getMarker());
    }

    @Test
    void hasWinnerPositiveDiagonal() throws Exception {
        TicTacToe game = new TicTacToe();

        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board board = (Board) boardField.get(game);

        board.place(0,0,'X');
        board.place(1,1,'X');
        board.place(2,2,'X');

        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinnerPositiveColumn() throws Exception {
        TicTacToe game = new TicTacToe();

        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board board = (Board) boardField.get(game);

        board.place(0,1,'X');
        board.place(1,1,'X');
        board.place(2,1,'X');

        assertTrue(game.hasWinner());
    }
}