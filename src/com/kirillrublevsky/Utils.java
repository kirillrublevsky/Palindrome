package com.kirillrublevsky;

/**
 * Class Utils contains utility static methods that convert long to int array and vise versa, as well as
 * method that checks if the number is a palindrome.
 */
public final class Utils {

    /**
     * Don't let anyone instantiate this class.
     */
    private Utils() {}

    /**
     * Returns boolean value. Checks if the input number is a palindrome. Uses other utility method to convert long
     * to int array. Then element by element compares all mirror digits. If they are equal returns true.
     *
     * @param input the long number to check
     * @return boolean is input number a palindrome or not
     */
    public static boolean isPalindrome(long input) {
        int[] inputArray = toIntArray(Math.abs(input));
        for (int i = 0; i < inputArray.length / 2; i++) {
            if (inputArray[i] != inputArray[inputArray.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Transforms long to array of ints, from 0 to 9. Uses Java 8 lambdas.
     *
     * @param input the long number to convert
     * @return int[] array of ints from 0 to 9
     */
    public static int[] toIntArray(long input) {
        return Long.toString(input).chars().map(c -> c -= '0').toArray();
    }

    /**
     * Transforms int array to one number of long primitive. Uses StringBuilder for that.
     *
     * @param inputArray array of ints from 0 to 9
     * @return long number
     */
    public static long toLong(int[] inputArray) {
        StringBuilder stringBuilder = new StringBuilder(inputArray.length);
        for (int element : inputArray) {
            stringBuilder.append(element);
        }
        return Long.valueOf(stringBuilder.toString());
    }
}
