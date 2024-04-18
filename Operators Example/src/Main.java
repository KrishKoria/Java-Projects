import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number :- ");
        int num1 = sc.nextInt();
        System.out.println("1) Check if a number is a power of 2");
        System.out.println("2) Convert to binary");
        System.out.print("Enter a choice :- ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                checkAndPrintExponent(num1);
                break;
            case 2:
                System.out.println(convertToBinary(num1));
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
    private static void checkAndPrintExponent(int num) {
        if (num != 0 && (num & (num - 1)) != 0) {
            System.out.println("Number is not a power of 2");
        } else if(num == 0) {
            System.out.println("Number is 0");
        } else {
            System.out.println("Number is a power of 2");
            double v = Math.log(num) / Math.log(2);
            System.out.println("Exponent is " + (int) v);
            System.out.print("2 ^ " + (int) v + " = " + num);
        }
    }
    private static String convertToBinary(int num) {
        StringBuilder sb = new StringBuilder();
            for (int i = 31; i >= 0; i--) {
                int k = num >> i;
                if ((k & 1) > 0)
                    sb.append("1");
                else
                    sb.append("0");
            }
        return sb.toString();
    }
}