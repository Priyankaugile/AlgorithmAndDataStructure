package com.algorithmprograms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {

        System.out.print("Enter any string:");
        Scanner scan = new Scanner(System.in);
        String input = scan .nextLine();
        Queue<Character> queue = new LinkedList<>();

        for (int i = input.length()-1; i >=0; i--) {
            queue.add(input.charAt(i));
        }

        String reverseString = " ";

        while (!queue.isEmpty()) {
            reverseString = reverseString+queue.remove();
        }
        if (input.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");

    }
}
