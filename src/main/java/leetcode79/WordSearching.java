package leetcode79;

public class WordSearching {

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int column;
    private String word;
    private boolean[][] visited;
    private char[][] board;

    private boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        column = board[0].length;
        visited = new boolean[rows][column];
        this.word = word;
        this.board = board;
        //从左上角开始搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        //如果相等
        if (board[i][j] == word.charAt(index)) {
            //标志已经访问过了
            visited[i][j] = true;
            for (int k = 0; k < direction.length; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < column;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearching wordSearching = new WordSearching();
        System.out.println(wordSearching.exist(board, "ABCCED"));
    }

}
