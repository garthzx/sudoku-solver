package com.company;

public class Patterns {
    public static void main(String[] args) {

        pattern1(6);
        pattern2(6);
    }
    // pyramid pattern

    public static int pattern1(int n)
    {
        if (n % 2 != 0) return 0;
        for (int i=0; i<n; i++) //outer loop for number of rows(n)
        {
            for (int j = n - i; j > 1; j--) //inner loop for spaces
            {
                System.out.print(" "); //print space
            }
            for (int j = 0; j <= i; j++) //inner loop for number of columns
            {
                System.out.print("* "); //print star
            }
            System.out.println();
        }
        return 0;
    }
    public static void pattern2(int n)
    {
        for (int i = 0; i <= n; i++)
        {
            for (int x = 1; x <= i+1; x++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
