package com.kirillrublevsky;

import java.util.Scanner;

import static com.kirillrublevsky.PalindromeFinder.getNearestLargerPalindrome;
import static com.kirillrublevsky.Utils.isPalindrome;

/**
 * Class Application contains main() method that runs application.
 */
public final class Application {

    /**
     * Don't let anyone instantiate this class.
     */
    private Application() {}

    /**
     * Runs application. The logic performed step by step is:
     * 1. Print the instruction to follow;
     * 2. Take long number from console;
     * 3. Check if it is already a palindrome;
     * 4. If no, find the palindrome using method of PalindromeFinder class;
     * 5. Catch exceptions.
     */
    public static void main(String[] args) {
        System.out.println("Enter the number to find nearest palindrome:");
        Scanner scanner = new Scanner(System.in);

        try {
            long input = scanner.nextLong();
            if (isPalindrome(input)) {
                System.out.println("This number is already a palindrome! Try again");
            } else {
                System.out.println("The nearest larger positive palindrome of " + input + " is: "
                        + getNearestLargerPalindrome(input));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}