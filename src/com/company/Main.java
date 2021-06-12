package com.company;

import java.awt.*;
import java.rmi.activation.ActivationGroupID;

public class SelfSolve {
    static int[][] grid = {
                            {5, 8, 0, 2, 0, 0, 4, 7, 0},
                            {0, 2, 0, 0, 0, 0, 0, 3, 0},
                            {0, 3, 0, 0, 5, 4, 0, 0, 0},
                            {0, 0, 0, 5, 6, 0, 0, 0, 0},
                            {0, 0, 7, 0, 3, 0, 9, 0, 0},
                            {0, 0, 0, 0, 9, 1, 0, 0, 0},
                            {0, 0, 0, 8, 2, 0, 0, 6, 0},
                            {0, 7, 0, 0, 0, 0, 0, 8, 0},
                            {0, 9, 4, 0, 0, 6, 0, 1, 5}};

    static final int GRID_SIZE = 9;

    public static void main(String[] args) {

        if (solved(grid, 0, 0))
        {
            print_solved_grid();
        }
        else
            System.out.println("No solution found");

    }
    public static boolean solved(int[][] array, int row, int column)
    {
        // these are our base cases
        // if we're at the 8th row and 9th column, stop backtracking.
        if (row == GRID_SIZE - 1 && column == GRID_SIZE) return true;

        // go to next row if column is 9 (last column)
        if (column == GRID_SIZE)
        {
            row++;
            column = 0;
        }

        // check if the current position contains value that's not zero.
        // then do recursion
        if (array[row][column] != 0)
            return solved(array, row, column + 1);

        // plug values 1-9
        for (int i = 1; i <= GRID_SIZE; i++)
        {
            if (validRow(array, row, column, i)
                && validColumn(array, row, column,i)
                && validGrid(array, row, column, i))
            {
                array[row][column] = i;
                if (solved(array, row, column + 1)) return true;
            }
            // if the plugged value is false, change it to 0
            // then plug another value.
            array[row][column] = 0;
        }
        return false;
    }

    public static boolean validRow(int[][] array, int row, int column, int plug)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[row][i] == plug)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean validColumn(int[][] array, int row, int column, int plug)
    {
        for (int i = 0; i < GRID_SIZE; i++)
        {
            if(array[i][column] == plug) return false;
        }
        return true;
    }
    public static boolean validGrid(int[][] array, int row, int column, int plug)
    {
        // check 3x3 for duplicates
        int startRow = row - row % 3;
        int startCol = column - column % 3;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 1; j < 3; j++)
            {
                if (array[i + startRow][j + startCol] == plug)
                    return false;
            }
        }
        return true;
    }
    public static void print_solved_grid()
    {
        for (int i = 0; i < GRID_SIZE; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
