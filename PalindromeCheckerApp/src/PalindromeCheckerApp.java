public class PalindromeCheckerApp {

    /*
    UC13: Performance Comparison of Palindrome Algorithms
    @author Developer
    @version 13.0
    */

    public static void main(String[] args) {
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version : 13.0");
        System.out.println("System initialized successfully");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();
        runComparison(input);
        scanner.close();
    }
    public static void runComparison(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        long startStack = System.nanoTime();
        boolean stackResult = checkWithStack(normalized);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;
        long startDeque = System.nanoTime();
        boolean dequeResult = checkWithDeque(normalized);
        long endDeque = System.nanoTime();
        long dequeTime = endDeque - startDeque;
        long startRecursive = System.nanoTime();
        boolean recursiveResult = checkRecursive(normalized, 0, normalized.length() - 1);
        long endRecursive = System.nanoTime();
        long recursiveTime = endRecursive - startRecursive;
        System.out.println("\nResults:");
        System.out.println("Stack Strategy: " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Strategy: " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("Recursive Strategy: " + recursiveResult + " | Time: " + recursiveTime + " ns");
    }
    private static boolean checkWithStack(String str) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return str.equals(reversed.toString());
    }
    private static boolean checkWithDeque(String str) {
        java.util.Deque<Character> deque = new java.util.LinkedList<>();
        for (char ch : str.toCharArray()) {
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
    private static boolean checkRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkRecursive(str, start + 1, end - 1);
    }
}