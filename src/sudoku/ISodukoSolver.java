package sudoku;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface ISodukoSolver {
    int[][] readSudoku(File file) throws IOException;

    boolean checkSudoku(int[][] rawSudoku);

    int[][] solveSudoku(int[][] rawSudoku);

    int[][] solveSudokuParallel(int[][] rawSudoku) throws ExecutionException, InterruptedException;
}
