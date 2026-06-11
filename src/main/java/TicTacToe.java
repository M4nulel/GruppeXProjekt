import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            int row = -1;
            int col = -1;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("row (0-2): ");
                row = scanner.nextInt();
                System.out.print("column (0-2): ");
                col = scanner.nextInt();

                if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board.isCellEmpty(row, col)) {
                    validInput = true;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            board.place(row, col, currentPlayer.getMarker());

            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                gameRunning = false;
            } else if (board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
                gameRunning = false;
            } else {
                switchCurrentPlayer(); // Wechselt den Spieler nach dem Zug
            }

        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char m = currentPlayer.getMarker();
        char c00 = board.isCellEmpty(0, 0) ? ' ' : m;


        char[][] c = board.cells;
        for (int i = 0; i < 3; i++) {
            if ((c[i][0] == m && c[i][1] == m && c[i][2] == m) || (c[0][i] == m && c[1][i] == m && c[2][i] == m)) {
                return true;
            }
        }
        if ((c[0][0] == m && c[1][1] == m && c[2][2] == m) || (c[0][2] == m && c[1][1] == m && c[2][0] == m)) {
            return true;
        }
        return false;
    }


}
