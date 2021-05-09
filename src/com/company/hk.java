package com.company;

import java.util.ArrayList;
import java.util.List;

public class hk {

    public static void main(String[] args) {
        int n = 6;
        for (int i = 0; i < n; i++)
        {
            for (int j = n - i; j > 1; j--)
            {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++)
            {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
