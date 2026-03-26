import java.util.Scanner;

public class A_Extremely_Round {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            if(n <= 10) {
                System.out.println(n);
            } else if(n <= 100) {
                System.out.println((n / 10) + 9);
            } else if(n <= 1000) {
                System.out.println((n / 100) + 18);
            } else if(n <= 10000) {
                System.out.println((n / 1000) + 27);
            } else if(n <= 100000) {
                System.out.println((n / 10000) + 36);
            } else {
                System.out.println((n / 100000) + 45);
            }

        }

        sc.close();;
    }
}