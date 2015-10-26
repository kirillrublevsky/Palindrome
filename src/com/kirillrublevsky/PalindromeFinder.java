package com.kirillrublevsky;

import static com.kirillrublevsky.Utils.toLong;
import static com.kirillrublevsky.Utils.toIntArray;

/**
 * Class PalindromeFinder contains public static method to find a palindrome nearest to the input number, as well as
 * two private utility methods.
 */
public final class PalindromeFinder {

    /**
     * Don't let anyone instantiate this class.
     */
    private PalindromeFinder() {}

    /**
     * Returns long number, a palindrome nearest to the input number. Logic performed step by step:
     * 1. Take the input long by modulus - in case it is negative;
     * 2. Create int[] array from input and find out mirror array using utility method;
     * 3. Convert mirror array to long;
     * 4. Check if this long number is bigger than input;
     * 5. If no, increment central element of array by one using utility method and transform it to long.
     *
     * @param input the long number to process
     * @return long resulting palindrome
     */
    public static long getNearestLargerPalindrome(long input) {
        input = Math.abs(input);
        int[] mirrorArray = createMirrorArray(toIntArray(input));
        long mirrorLong = toLong(mirrorArray);

        if (mirrorLong > input) {
            return mirrorLong;
        } else return toLong(incrementByOne(mirrorArray));
    }

    /**
     * Returns int[] - mirror array, where all symmetric digits are equal. It takes input array and
     * substitutes right from the center digits with symmetric left ones.
     *
     * @param inputArray the int array to process
     * @return int[] array with equal symmetric numbers
     */
    private static int[] createMirrorArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length / 2; i++) {
            inputArray[inputArray.length - 1 - i] = inputArray[i];
        }
        return inputArray;
    }

    /**
     * Returns int[] - array with central element incremented by one. The aim of this method is to create
     * mirror int array that is guaranteed larger than the input array. That is why because just substitution
     * of symmetric elements often returns palindrome that is lesser than input number. Logic step by step:
     * 1. Find index of central element of array (for integers with odd number of digits);
     * 2. Increment this element by one;
     * 3. Check if it became 10 - if yes, increase previous digit by one and set this one to zero;
     * 4. Create mirror array using utility method.
     *
     * @param input the int array to process
     * @return int[] array with equal symmetric numbers that is guaranteed larger than the input
     */
    private static int[] incrementByOne(int[] input) {
        int centralIndex = (input.length - 1) / 2;
        input[centralIndex] += 1;
        for (int i = centralIndex; i > 0; i--) {
            if (input[i] == 10) {
                input[i] = 0;
                input[i - 1] += 1;
            }
        }
        return createMirrorArray(input);
    }
}