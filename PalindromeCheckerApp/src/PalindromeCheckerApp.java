import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    /*
    UC6: Queue + Stack Based Palindrome Check
    @author Developer
    @version 1.0
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check if it is a palindrome: ");
        String word = scanner.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            queue.add(ch);   // enqueue
            stack.push(ch);  // push
        }
        boolean isPalindrome = true;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            char fromQueue = queue.remove(); // dequeue
            char fromStack = stack.pop();    // pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
        scanner.close();
    }
}