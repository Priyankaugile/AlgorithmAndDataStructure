package com.algorithmprograms;

public class StaticPermutationOfString {

    // Recursive function to generate all permutations of a string
    private static void permutations(String a, String b)
    {
        if (b.length() == 0) {
            System.out.println(a);
        }

        for (int i = 0; i < b.length(); i++)
        {
            String newCandidate = a + b.charAt(i);

            String newRemaining = b.substring(0, i) +
                    b.substring(i + 1);

            permutations(newCandidate, newRemaining);
        }
    }

    // Find Permutations of a string in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations("", s);
    }
}
