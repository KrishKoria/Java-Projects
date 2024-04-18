import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String to check palindrome : ");
        String s = sc.nextLine();
        boolean checkPalindrome = isPalindrome(s.toLowerCase());
        if (checkPalindrome) {
            System.out.println("this is a Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        sc.close();
    }
    private static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return true;
        if (s.charAt(0) == s.charAt(s.length() - 1)) return isPalindrome(s.substring(1, s.length() - 1));
        return false;
    }
}