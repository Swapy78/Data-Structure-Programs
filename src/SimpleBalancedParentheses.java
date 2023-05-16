//Java program to check if an Arithmetic Expression is balanced or not

package demo2;

import java.util.*;

public class SimpleBalancedParentheses {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // Telling the user to enter an arithmetic expression
      System.out.print("Enter an arithmetic expression: ");
      String expression = sc.nextLine();

      // Checking if the expression is balanced
      if (isBalanced(expression)) {
          System.out.println("The arithmetic expression is balanced.");
      } else {
          System.out.println("The arithmetic expression is not balanced.");
      }

      // Closing the scanner
      sc.close();
  }

  // Function to check if an arithmetic expression is balanced
  public static boolean isBalanced(String expression) {
      // Creating a stack to store the opening parentheses
      Stack<Character> stack = new Stack<>();

      // Looping through each character in the expression
      for (int i = 0; i < expression.length(); i++) {
          char ch = expression.charAt(i);

//If the character is an opening parenthesis, pushing it onto the stack
          if (ch == '(') {
              stack.push(ch);
          } 
//If the character is a closing parenthesis, popping the top element from the stack
          else if (ch == ')') {
              // If the stack is empty, the expression is unbalanced
              if (stack.isEmpty()) {
                  return false;
              }
              stack.pop();
          }
      }

      // If the stack is empty, the expression is balanced
      return stack.isEmpty();
  }
}
