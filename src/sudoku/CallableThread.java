package sudoku;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<int[][]> {

    SudokuSolver ss = new SudokuSolver();
    public static int[][] board = SudokuSolver.board;

    public CallableThread(int[][] board) {
        this.board = board;
    }

    @Override
    public int[][] call() throws Exception {
        ss.checkSudoku(board);
        return board;
    }
}
