/**
 * Created by mming on 10/14/18.
 */
public class Suduko {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] map = new int[10];
            for (int j = 0; j < board[i].length; j++) {
                if (!checkRepeat(map, board, i, j)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            int[] map = new int[10];
            for (int j = 0; j < board.length; j++) {
                if (!checkRepeat(map, board, j, i)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if (!checkSubBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;

    }
    private boolean checkSubBox(char[][] board, int x, int y) {
        int[] map = new int[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (!checkRepeat(map, board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkRepeat(int[] map, char[][] board, int i, int j) {
        char c = board[i][j];
        if (c == '.') {
            return true;
        }
        if (c < '0' || c > '9') {
            return false;
        }
        if (map[c - '0'] == 0) {
            map[c - '0']++;
            return true;
        } else {
            return false;
        }
    }
}
