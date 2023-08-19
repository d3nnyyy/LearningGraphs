package ua.dtsebulia.randomLeetCodeProblems;

import java.util.Arrays;
import java.util.List;

public class SudokuSolver {

    public static void main(String[] args) {

        String[][] grid = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};

        System.out.println(Arrays.deepToString(solveSudoku(grid)));
    }

    public static String[][] solveSudoku(String[][] grid) {

        List<Integer> emptyCell = findEmptyCell(grid);

        int row = emptyCell.get(0);
        int col = emptyCell.get(1);

        if (row == -1 && col == -1) {
            return grid;
        }

        for (int num = 1; num <= 9; num++) {

            if (isValid(row, col, num, grid)) {
                grid[row][col] = String.valueOf(num);

                if (solveSudoku(grid) != null) {
                    return grid;
                }

                grid[row][col] = ".";
            }

        }

        return null;
    }

    private static List<Integer> findEmptyCell(String[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j].equals(".")) {
                    return Arrays.asList(i, j);
                }
            }
        }
        return Arrays.asList(-1, -1);
    }

    private static boolean isValid(int row, int col, int num, String[][] grid) {

        for (int i = 0; i < 9; i++) {
            if (grid[i][col].equals(String.valueOf(num))) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (grid[row][i].equals(String.valueOf(num))) return false;
        }

        int row0 = row / 3;
        int col0 = col /3;
        row0 *= 3;
        col0 *= 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[row0+i][col0+j].equals(String.valueOf(num))) return false;
            }
        }

        return true;
    }

}
