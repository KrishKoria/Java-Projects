import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ":");
            int num = scanner.nextInt();
            numbers.add(num);
        }
        System.out.println("HashSet: " + numbers);

        numbers.clear();
        System.out.println("HashSet after removal: " + numbers);
    }
}