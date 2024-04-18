import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ":");
            int num = scanner.nextInt();
            numbers.put(num, num);
        }
        System.out.println("HashMap: " + numbers);

        for (Integer key : numbers.keySet().toArray(new Integer[0])) {
            numbers.remove(key);
        }
        System.out.println("HashMap after removal: " + numbers);
    }
}