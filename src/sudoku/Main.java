package sudoku;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SudokuSolver ss = new SudokuSolver();
        int[][] input = ss.readSudoku(new File("1_sudoku_level1.csv"));

        System.out.println(">--- ORIGINAL ---");
        print(input);
        int[][] output = ss.solveSudoku(input);
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
        int runs = 10;
        long stime = System.nanoTime() / 1000000;
        while(runs != 0){
            SudokuSolver ss = new SudokuSolver();
            try {
                ss.readSudoku(new File("1_sudoku_level1.csv"));
                ss.checkSudoku(rawSudoku);
                ss.solveSudoku(rawSudoku);
            } catch (IOException e) {
                e.printStackTrace();
            }

            runs --;
        }
        long etime = System.nanoTime() / 1000000;

        return (etime - stime) / 10;
    }

}
