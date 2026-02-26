public class PalindromeCheckerApp {

    /*
    UC10: Case-Insensitive & Space-Ignored Palindrome Checker
    @author Developer
    @version 10.0
    */

    public static void main(String[] args) {
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version : 10.0");
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

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
