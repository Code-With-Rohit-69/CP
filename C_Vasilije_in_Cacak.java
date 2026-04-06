import java.util.Scanner;

public class C_Vasilije_in_Cacak {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long x = sc.nextLong();

            long half = n / 2;

            if(half < x) {
                for (long i = n; i >= 1 && k > 0 && x > 0; i--) {
                    if(x >= i) {
                        x -= i;
                        k--;
                    }
                }
            } else {
                for (long i = 1; i <= n && k > 0 && x > 0; i++) {
                    if(x >= i) {
                        x -= i;
                        k--;
                    }
                }
            }


            if (x == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }

        sc.close();
    }
}