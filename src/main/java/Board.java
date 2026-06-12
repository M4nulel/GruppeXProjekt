public class Board {
    protected char[][] cells;

    public Board() {
        cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + cells[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---");
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false; // Sobald auch nur eine Zelle leer ist, ist das Board NICHT voll
                }
            }
        }
        return true; // Keine leere Zelle gefunden -> Das Board ist voll (Unentschieden)
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }








}
