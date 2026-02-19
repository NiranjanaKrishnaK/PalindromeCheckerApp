import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    /*
    UC5: Stack-Based Palindrome Checker
    @author Developer
    @version 1.0
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a word to check if it is a palindrome: ");
        String word = scanner.nextLine();

        // Create a stack of characters
        Stack<Character> stack = new Stack<>();

        // Push each character into the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        // Pop characters to build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        // Compare original and reversed using equals()
        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }

        scanner.close();
    }
}