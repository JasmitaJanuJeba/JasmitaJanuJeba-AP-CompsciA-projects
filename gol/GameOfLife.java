package gol;

public class GameOfLife implements Board {

    private int[][] board;

    public GameOfLife(int x, int y)
    {
        // Construct a 2D array of size x by y
        board = new int[x][y];
    }

    // Set values on the board
    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                board[x + i][y + j] = data[i][j];
            }
        }
    }

    // Run the simulation for a number of turns
    @Override
    public void run(int turns) {
        for (int i = 0; i < turns; i++) {
            step();
        }
    }

    // Step the simulation forward one turn.
    @Override
    public void step()
    {
        print();

        int rows = board.length;
        int cols = board[0].length;

        int[][] next = new int[rows][cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {

                int neighbors = countNeighbors(x, y);
                int cell = board[x][y];

                if (cell == 1) {
                    next[x][y] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    next[x][y] = (neighbors == 3) ? 1 : 0;
                }
            }
        }

        board = next;
    }

    // Count neighbors with wrapping
    @Override
    public int countNeighbors(int x, int y) {
        int count = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {

                if (dx == 0 && dy == 0) continue;  // skip itself

                if (get(x + dx, y + dy) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    // Get a value from the board with wrap-around
    @Override
    public int get(int x, int y) {
        int rows = board.length;
        int cols = board[0].length;
        return board[(x + rows) % rows][(y + cols) % cols];
    }

    // Test helper to get entire board
    @Override
    public int[][] get() {
        return board;
    }

    // Print the board
    public void print(){
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y % 10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + (x % 10));
            for (int y = 0; y < board[x].length; y++) {
                System.out.print(board[x][y] == 1 ? "⬛" : "⬜");
            }
        }
        System.out.println();
    }
}
