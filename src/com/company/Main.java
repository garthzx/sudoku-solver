package com.company;

public class Main {
    final static int N = 9;

    public static void main(String[] args) {
        int[][] arr = {{5, 8, 0, 2, 0, 0, 4, 7, 0},
                {0, 2, 0, 0, 0, 0, 0, 3, 0},
                {0, 3, 0, 0, 5, 4, 0, 0, 0},
                {0, 0, 0, 5, 6, 0, 0, 0, 0},
                {0, 0, 7, 0, 3, 0, 9, 0, 0},
                {0, 0, 0, 0, 9, 1, 0, 0, 0},
                {0, 0, 0, 8, 2, 0, 0, 6, 0},
                {0, 7, 0, 0, 0, 0, 0, 8, 0},
                {0, 9, 4, 0, 0, 6, 0, 1, 5}};

        if (solve(arr, 0, 0))
        {
            print(arr);
        }
        else
            System.out.println("No solution");

    }
    public static boolean solve(int[][] array, int row, int column)
    {
        // base cases to avoid going over backtracking
        //
        if (row == N - 1 && column == N) return true;

        // go to next row if column is 9 (last column)
        if (column == N)
        {
            row++;
            column = 0;
        }
        // check if the current position contains value that's not zero.
        if (array[row][column] != 0)
            return solve(array, row, column + 1); // + 1 to go next

        // plug values 1 - 9
        for (int plugVal = 1; plugVal < 10; plugVal++)
        {
            if (isSafe(array, row, column, plugVal))
            {
                array[row][column] = plugVal;

                if (solve(array, row, column + 1))
                    return true;
            }
            // remove assigned number if wrong, and try a different value;
            array[row][column] = 0;
        }
        return false;
    }
    public static  boolean isSafe(int[][] array, int row, int col, int plugval)
    {
        // check row for duplicates
        for (int i = 0; i < 9; i++)
        {
            if (array[row][i] == plugval) return false;
        }
        // check column for duplicates
        for (int i = 0; i < 9; i++)
        {
            if (array[i][col] == plugval) return false;
        }

        // check 3x3 for duplicates
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (array[i + startRow][j + startCol] == plugval) return false;

        return true;
    }
    // print the board
    public static void print(int[][] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }
}