public class HasPath {
    public static void main(String[] args){
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};

        System.out.println(new HasPath().ExistPath(matrix, "bcced"));
    }

    public boolean ExistPath(char[][] matrix, String string) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (helper(matrix, string, visited, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] matrix, String string, boolean[][] visited,
                          int index, int row, int col) {
        if (index == string.length())
            return true;
        boolean hasPath = false;
        visited[row][col] = true;
        if (row >= 0 && row < matrix.length && col>=0 && col<matrix[0].length &&
                matrix[row][col] == string.charAt(index) && !visited[row][col]) {
            hasPath = helper(matrix, string, visited, index + 1, row + 1, col) ||
                    helper(matrix, string, visited, index + 1, row, col + 1) ||
                    helper(matrix, string, visited, index + 1, row - 1, col) ||
                    helper(matrix, string, visited, index + 1, row, col - 1);
            if (!hasPath){
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
