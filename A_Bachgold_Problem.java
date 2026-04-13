import java.util.Scanner;

public class A_Bachgold_Problem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(n / 2);

        if((n & 1) == 0) {
            for (int i = 0; i < n / 2; i++) {
                System.out.print(2 + " ");
            }
        } else {
            for (int i = 0; i < (n / 2) - 1; i++) {
                System.out.print(2 + " ");
            }
            System.out.print(3 + " ");
        }

        sc.close();
    }
}