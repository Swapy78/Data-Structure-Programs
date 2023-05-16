//Java program to check if the string is palindrome or not

package demo;

import java.util.*;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // taking a string input from user
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        // creating a deque to store the characters
        Deque<Character> deque = new ArrayDeque<>();
        
        // adding each character of the string to the rear of the deque
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            deque.addLast(ch);
        }
        
        boolean isPalindrome = true;
        
        // checking if the string is palindrome or not
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();
            
// if the first and last characters are not equal, then it is not palindrome
            if (first != last) {
                isPalindrome = false;
                break;
            }
        }
        
        // printing the result
        if (isPalindrome) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
        
        sc.close();
    }

}
