import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        String binary = Integer.toBinaryString(n);

        StringBuilder onesComplement = new StringBuilder();
        for (char c : binary.toCharArray()) {
            onesComplement.append(c == '0' ? '1' : '0');
        }

        int onesComplementInt = Integer.parseInt(onesComplement.toString(), 2);
        int twosComplement = onesComplementInt + 1;

        System.out.println("2's Complement : " + Integer.toBinaryString(twosComplement));
        sc.close();
    }   
}