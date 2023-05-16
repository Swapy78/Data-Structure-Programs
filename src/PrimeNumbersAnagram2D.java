//Java program to find Anagram & Non-Anagram numbers from 0-1000 and store in 2D array

package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbersAnagram2D {

    public static void main(String[] args) {
        // Creating a 2D array with 10 rows and 100 columns to store the prime numbers
        int[][] primes = new int[10][100];
        // Creating two lists to store prime numbers that are anagrams and prime numbers that are not anagrams
        List<Integer> anagrams = new ArrayList<>();
        List<Integer> notAnagrams = new ArrayList<>();

        // Initializing the index to 0
        int index = 0;

        // Looping through the range of numbers from 2 to 1000
        for (int i = 2; i <= 1000; i++) {
            // Assuming the number is prime until proven otherwise
            boolean isPrime = true;

            // Checking if the number is divisible by any number between 2 and its square root
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    // If the number is divisible by any number other than itself and 1, it's not prime
                    isPrime = false;
                    break;
                }
            }

            // If the number is prime, adding it to the 2D array and incrementing the index
            if (isPrime) {
                primes[index / 100][index % 100] = i;
                index++;

                // Check if the number is anagram with any of the previously stored primes
                boolean isAnagram = false;
                for (int j = 0; j < anagrams.size(); j++) {
                    if (areAnagrams(anagrams.get(j), i)) {
                        isAnagram = true;
                        break;
                    }
                }

                // Add the prime number to the appropriate list
                if (isAnagram) {
                    notAnagrams.add(i);
                } else {
                    anagrams.add(i);
                }
            }
        }

        // Storing the anagrams and not anagrams in separate 2D arrays
        int[][] anagramPrimes = new int[anagrams.size()][];
        int[][] notAnagramPrimes = new int[notAnagrams.size()][];
        for (int i = 0; i < anagrams.size(); i++) {
            anagramPrimes[i] = toArray(anagrams.get(i));
        }
        for (int i = 0; i < notAnagrams.size(); i++) {
            notAnagramPrimes[i] = toArray(notAnagrams.get(i));
        }

        // Printing the anagram prime numbers
        System.out.println("Anagram Prime Numbers:");
        for (int i = 0; i < anagramPrimes.length; i++) {
            if (anagramPrimes[i].length > 1) {
                System.out.println(Arrays.toString(anagramPrimes[i]));
            }
        }

      
        // Printing the non-anagram prime numbers
        System.out.println("Non-Anagram Prime Numbers:");
        for (int i = 0; i < notAnagramPrimes.length; i++) {
            System.out.println(Arrays.toString(notAnagramPrimes[i]));
        }
    }

    private static int[] toArray(Integer integer) {
        return getDigits(integer);
    }

    // Method to check if two numbers are anagrams
    public static boolean areAnagrams(int num1, int num2) {
        int[] digits1 = getDigits(num1);
        int[] digits2 = getDigits(num2);
        Arrays.sort(digits1);
        Arrays.sort(digits2);
        return Arrays.equals(digits1, digits2);
   

    }

    // Method to convert a number to an array of its digits
    public static int[] getDigits(int number) {
    	// Converting the number to a string
    	String numString = Integer.toString(number);
    	// Creating an array to store the digits
    	int[] digits = new int[numString.length()];
    	// Looping through each character in the string and converting it to an integer
    	for (int i = 0; i < numString.length(); i++) {
    	digits[i] = Character.getNumericValue(numString.charAt(i));
    	}
    	// Returning the array of digits
    	return digits;
    	}
}






