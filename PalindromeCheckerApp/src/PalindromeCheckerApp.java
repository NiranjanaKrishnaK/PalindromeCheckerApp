public class PalindromeCheckerApp {

    /*
    UC9: Recursive Palindrome Checker
    @author Developer
    @version 9.0
    */

    public static void main(String[] args) {
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version : 9.0");
        System.out.println("System initialized successfully");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome!");
        }

        scanner.close();
    }
    public static boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return checkRecursive(normalized, 0, normalized.length() - 1);
    }
    private static boolean checkRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return checkRecursive(str, start + 1, end - 1);
    }
}
