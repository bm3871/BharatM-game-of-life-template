import java.util.Arrays;

public class GameOfLife implements Board {
    private int[][] board;
    
    public GameOfLife(int x, int y) {
        board = new int[x][y];
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
        // count the number of neighbors the cell has
        // use the get(x,y) method to read any board state you need.
        return count;
    }

    // Get a value from the board with "wrap around"
    // Locations outside the board will loop back into the board.
    // Ex: -1 will read board.length-1
    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit= board[0].length;
        return board[(x+xLimit)%xLimit][(y+yLimit)%yLimit];
    }

    // Test helper to get the whole board state
    public int[][] get()
    {
        return board;
    }

    // Test helper to print the current state
    public void print(){
        // Print the header
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y%10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x%10);
            for (int y=0; y<board[x].length; y++)
            {
                if (board[x][y] == 1)
                {
                    System.out.print("⬛");
                }
                else
                {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
