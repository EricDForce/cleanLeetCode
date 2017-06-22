import java.util.HashSet;

/**
 * Created by eric-d on 2017/6/21.
 */
public class ValidSudoku {
    public static void main(String[] args){
        String[] s = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char[][] board = new char[9][9];
        for (int i=0;i<9;i++){
            board[i] = s[i].toCharArray();
        }
        new ValidSudoku().solveSudoku(board);

        for (int i=0;i<9;i++){
            System.out.println(board[i]);
        }
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public boolean helper(char[][] board){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j] == '.'){
                    for (char k='1';k<='9';k++){
                        if (isValid(board, i, j, k))
                        {
                            board[i][j] = k;
                            if (!helper(board))
                                board[i][j] = '.';
                            else
                                return true;
                        } else
                        {
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<board.length;i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }

                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char k){
//        board[row][col] = k;
//        HashSet<Character> rows = new HashSet<>();
//        HashSet<Character> cols = new HashSet<>();
//        HashSet<Character> cube = new HashSet<>();
        for (int i=0;i<9;i++){
            if ((board[row][i] != '.' && board[row][i]==k) ||
                    (board[i][col] != '.' && board[i][col]==k)) {
                return false;
            }
            int rowIndex = 3*(row / 3);
            int colIndex = 3*(col / 3);
            if (board[rowIndex+i/3][colIndex+i%3] != '.' && board[rowIndex+i/3][colIndex+i%3]==k){
                return false;
            }
//            if ((board[row][i] != '.' && !rows.add(board[row][i])) ||
//                    (board[i][col] != '.' && !cols.add(board[i][col]))) {
//                return false;
//            }
//            int rowIndex = 3*(row / 3);
//            int colIndex = 3*(col / 3);
//            if (board[rowIndex+i/3][colIndex+i%3] != '.' && !cube.add(board[rowIndex+i/3][colIndex+i%3])){
//                return false;
//            }
        }
        return true;
    }
}
