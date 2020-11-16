package sudoku;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        SudokuSolver ss = new SudokuSolver();
        int[][] input = ss.readSudoku(new File("1_sudoku_level1.csv"));

        System.out.println(">--- ORIGINAL ---");
        print(input);
        int[][] output = ss.solveSudokuParallel(input);
        System.out.println(">--- SOLUTION ---");
        print(output);
        System.out.println(">----------------");
        System.out.println("SOLVED    = " + ss.checkSudoku(output));
        System.out.println(">----------------");

        System.out.println("Benchmark:");
        System.out.println(benchmark(input));
    }

    public static void print(int[][] rawSudoku){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(rawSudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static long benchmark(int[][] rawSudoku){
        // Nicht Parallel = 0-1 ms
        //       Parallel = 2-3 ms
        int runs = 10;
        long stime = System.currentTimeMillis();
        while(runs != 0){
            SudokuSolver ss = new SudokuSolver();
            try {
                ss.readSudoku(new File("1_sudoku_level1.csv"));
                ss.checkSudoku(rawSudoku);
                ss.solveSudoku(rawSudoku);
                //ss.solveSudokuParallel(rawSudoku);
            } catch (IOException e) {
                e.printStackTrace();
            }

            runs --;
        }
        long etime = System.currentTimeMillis();

        return (etime - stime) / 10;
    }

}
