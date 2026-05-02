import java.util.Scanner;

public class A_Odd_Set {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int even = 0;

            for(int i = 0; i < 2 * n; i++) {
                int x = sc.nextInt();

                if(x % 2 == 0) {
                    even++;
                }
            }

            int odd = 2 * n - even;

            if (even != odd) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }

        sc.close();
    }
}