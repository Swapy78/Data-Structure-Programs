//Java program to add anagram prime numbers in range 0-1000 in Queue.

package demo;

import java.util.Arrays;
import java.util.LinkedList;

// defining class
public class PrimeNumbersAnagramQueue {
	// main method to execute the program
	public static void main(String[] args) {

		// creating a new linked list to represent a queue
		LinkedList<Integer> queue = new LinkedList<>();

		// looping through each number from 2 to 1000
		for (int i = 2; i <= 1000; i++) {

			// checking if the number is prime
			if (isPrime(i)) {

				// if the queue is empty, adding the number to the queue
				if (queue.isEmpty()) {
					queue.add(i);

// if the queue is not empty, checking if the number is an anagram of any number in the queue
				} else {
					LinkedList<Integer> tempQueue = new LinkedList<>();
					while (!queue.isEmpty() && areAnagrams(queue.peek(), i)) {
						tempQueue.add(queue.remove());
					}
					queue.add(i);
					while (!tempQueue.isEmpty()) {
						queue.add(tempQueue.remove());
					}
				}
			}
		}

		// printing the anagram prime numbers in order from the queue
		System.out.println("Anagram prime numbers in order:");
		while (!queue.isEmpty()) {
			System.out.println(queue.remove());
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
		int[] digits1 = getDigits(num1);
		int[] digits2 = getDigits(num2);
		Arrays.sort(digits1);
		Arrays.sort(digits2);
		return Arrays.equals(digits1, digits2);
	}

	// method to get the digits of a number
	public static int[] getDigits(int number) {
		String numString = Integer.toString(number);
		int[] digits = new int[numString.length()];
		for (int i = 0; i < numString.length(); i++) {
			digits[i] = Character.getNumericValue(numString.charAt(i));
		}
		return digits;
	}
}