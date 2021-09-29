package com.algorithmprograms;

import java.util.Scanner;

public class PrimePalindrome {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int number, temp, rem, i;
        int count = 0;
        int sum = 0;

        System.out.println("Enter number to check");
        number = sc.nextInt();

        temp = number;

        for(i = 1; i <= temp; i++)
        {
            if(temp%i == 0)
            {
                count++;
            }
        }

        while(number > 0)
        {
            rem = number%10;
            sum = sum*10+rem;
            number = number/10;
        }

        if(temp == sum && count == 2)
        {
            System.out.println(temp +" is a PalPrime number");
        }
        else
        {
            System.out.println(temp +" is not a PalPrime number");
        }
    }
}
