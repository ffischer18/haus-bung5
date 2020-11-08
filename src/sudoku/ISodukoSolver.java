package sudoku;

import java.io.File;

public interface ISodukoSolver {
    int[][] readSudoku(File file);

    boolean checkSudoku(int[][] rawSudoku);

    int[][] solveSudoku(int[][] rawSudoku);

    int[][] solveSudokuParallel(int[][] rawSudoku);
}
