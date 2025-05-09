
import java.util.*;

class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);

        char player = 'X';
        boolean gameOver = false;

        try (Scanner sc = new Scanner(System.in)) {
            while (!gameOver) {
                printBoard(board);
                int row, col;

                while (true) {
                    System.out.print("Player " + player + ", enter your move (row[0-2] and column[0-2]): ");
                    row = sc.nextInt();
                    col = sc.nextInt();

                    if (isValidMove(board, row, col)) {
                        break;
                    }
                    System.out.println("Invalid move! Try again.");
                }

                board[row][col] = player;

                if (checkWin(board, player)) {
                    printBoard(board);
                    System.out.println("🎉 Player " + player + " wins!");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("🤝 It's a draw!");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // Switch player
                }
            }
        } // Scanner automatically closed here
    }

    private static void initializeBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            Arrays.fill(board[row], ' ');
        }
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char[][] board, char player) {
        // Rows, Columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player)
                    || (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static void printBoard(char[][] board) {
        System.out.println("\nCurrent board:");
        for (int row = 0; row < 3; row++) {
            System.out.print(" ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();

    }

}
