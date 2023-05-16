//Java program to store prime numbers in 2D array

package demo;

public class PrimeNumbers2D {

    public static void main(String[] args) {
// Creating a 2D array with 10 rows and 100 columns to store the prime numbers
        int[][] primes = new int[10][100];
        
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
            }
        }
        
// Looping through each row of the 2D array and printing the prime numbers
        for (int i = 0; i < 10; i++) {
            // Printing the range of numbers for this row
            System.out.print((i * 100) + "-" + ((i + 1) * 100 - 1) + ": ");
            
  // Looping through each column of this row and printing the prime numbers
            for (int j = 0; j < 100; j++) {
                if (primes[i][j] != 0) {
                    System.out.print(primes[i][j] + " ");
                }
            }
            
            // Moving to the next line
            System.out.println();
        }
    }
}
