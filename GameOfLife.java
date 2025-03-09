import java.util.Arrays;

public class GameOfLife implements Board {
    private int[][] board;

    public GameOfLife(int x, int y) {
        board = new int[x][y];
    }

    public void set(int startX, int startY, int[][] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
                int x = startX + i;
                int y = startY + j;
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                    board[x][y] = pattern[i][j];
                }
            }
        }
    }

    public void run(int turns) {
        for (int i = 0; i < turns; i++) {
            step();
        }
    }

    public void step() {
        int[][] newBoard = new int[board.length][board[0].length];

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                int neighbors = countNeighbors(x, y);

                if (board[x][y] == 1) {
                    newBoard[x][y] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    newBoard[x][y] = (neighbors == 3) ? 1 : 0;
                }
            }
        }

        board = newBoard;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                count += get(x + dx, y + dy);
            }
        }
        return count;
    }

    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit = board[0].length;
        return board[(x + xLimit) % xLimit][(y + yLimit) % yLimit];
    }

    public int[][] get() {
        return board;
    }

    public void print() {
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y % 10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x % 10);
            for (int y = 0; y < board[x].length; y++) {
                System.out.print(board[x][y] == 1 ? "⬛" : "⬜");
            }
        }
        System.out.println();
    }
}