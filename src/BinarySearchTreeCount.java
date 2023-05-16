//Java program to find the number of different binary search trees that can be created using nodes

package demo;

import java.util.Scanner;

public class BinarySearchTreeCount {
    private static final int MOD = 1000000007;//given in problem

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        for (int i = 0; i < t; i++) {
        	// number of nodes in the binary search tree
            int n = sc.nextInt(); 
            int result = countBinarySearchTrees(n);
            System.out.println(result);
        }

        sc.close(); // Closing the Scanner
    }

    private static int countBinarySearchTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        // Calculating the count for each number of nodes from 2 to n
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count[i] = (count[i] + (int) ((long) count[j - 1] * count[i - j] % MOD)) % MOD;
            }
        }

        return count[n]; // Returning the count for n nodes
    }
}
