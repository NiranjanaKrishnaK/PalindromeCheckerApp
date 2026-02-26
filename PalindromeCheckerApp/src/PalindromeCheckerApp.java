public class PalindromeCheckerApp {

    /*
    UC12: Strategy Pattern for Palindrome Algorithms (Advanced)
    @author Developer
    @version 12.0
    */

    public static void main(String[] args) {
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version : 12.0");
        System.out.println("System initialized successfully");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Choose strategy dynamically
        System.out.println("Choose strategy: 1) Stack  2) Deque");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        if (strategy.checkPalindrome(input)) {
            System.out.println("\"" + input + "\" is a Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome!");
        }

        scanner.close();
    }
}
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return normalized.equals(reversed.toString());
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        java.util.Deque<Character> deque = new java.util.LinkedList<>();
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}