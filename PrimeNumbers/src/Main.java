import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter Number till Prime Numbers are to be printed: ");
        int n = sc.nextInt();
        for(int i = 2; i <= n; i++) {
            int flag = 0;
            for(int j = 2; j <= i/2; j++) {
                if(i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                System.out.print(i + " ");
        }

    }
}