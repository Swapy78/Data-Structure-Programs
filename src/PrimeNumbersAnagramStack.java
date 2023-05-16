//Java program to add anagram prime numbers from range 0-1000 to stack in reversed order

package demo;

import java.util.Arrays;
import java.util.LinkedList;

public class PrimeNumbersAnagramStack {

    public static void main(String[] args) {
// Creating a new linked list to act as the stack for anagram prime numbers
        LinkedList<Integer> stack = new LinkedList<>();
        
    // Looping through numbers from 2 to 1000 to check for prime numbers
        for (int i = 2; i <= 1000; i++) {
            // Checking if current number is a prime number
            if (isPrime(i)) {
                // If the stack is empty, adding the current number to it
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
      // Creating a temporary stack to hold anagrams of the current number
                    LinkedList<Integer> tempStack = new LinkedList<>();
// While the main stack is not empty and the current number is an anagram of the top number in the stack, moving the top number to the temporary stack
                    while (!stack.isEmpty() && areAnagrams(stack.peek(), i)) {
                        tempStack.push(stack.pop());
                    }
                    // Adding the current number to the main stack
                    stack.push(i);
    // Moving the anagrams back from the temporary stack to the main stack
                    while (!tempStack.isEmpty()) {
                        stack.push(tempStack.pop());
                    }
                }
            }
        }
        // Printing out the anagram prime numbers in reverse order
        System.out.println("Anagram prime numbers in reverse order:");
        while (!stack.isEmpty()) {
// Popping a number off the stack and check if it's an anagram of any numbers further down the stack
            int num = stack.pop();
            if (isPrime(num) && stack.stream().anyMatch(x -> areAnagrams(x, num))) {
// If the popped number is an anagram of another number further down the stack, printing it out
                System.out.println(num);
            }
        }
    }

    // method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // method to check if two numbers are anagrams of each other
    public static boolean areAnagrams(int num1, int num2) {
        // Converting the numbers to arrays of their digits and sort them
        int[] digits1 = getDigits(num1);
        int[] digits2 = getDigits(num2);
        Arrays.sort(digits1);
        Arrays.sort(digits2);
// Checking if the sorted arrays of digits are equal (i.e. the numbers are anagrams)
        return Arrays.equals(digits1, digits2);
    }

    // method to get the digits of a number in an array
    public static int[] getDigits(int number) {
        // Converting the number to a string
        String numString = Integer.toString(number);
        // Creating an array to hold the digits
        int[] digits = new int[numString.length()];
// Looping through each character in the string and add its numeric value to the array
        for (int i = 0; i < numString.length(); i++) {
            digits[i] = Character.getNumericValue(numString.charAt(i));
        }
        // Returning the array of digits
        return digits;
    }
}
