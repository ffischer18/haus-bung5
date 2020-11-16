package sudoku;

import java.io.File;
import java.io.IOException;

public interface ISodukoSolver {
    int[][] readSudoku(File file) throws IOException;

    boolean checkSudoku(int[][] rawSudoku);

    int[][] solveSudoku(int[][] rawSudoku);

    int[][] solveSudokuParallel(int[][] rawSudoku);
}
