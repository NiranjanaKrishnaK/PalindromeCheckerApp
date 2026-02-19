import java.util.Scanner;
public class PalindromeCheckerApp {

    /*
    UC1
    @author Developer
    @version 1.0
    */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check if it is a palindrome: ");
        String word = scanner.nextLine();
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
        scanner.close();
    }
}