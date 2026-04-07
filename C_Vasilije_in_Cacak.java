import java.util.Scanner;

public class C_Vasilije_in_Cacak {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long x = sc.nextLong();

            long minSum = k * (k + 1) / 2;
            long remaining = n - k;

            long remainingSum = remaining * (remaining + 1) / 2;

            long maxSum = (n * (n + 1) / 2 ) - remainingSum;

            if (x >= minSum && x <= maxSum) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            


        }

        sc.close();
    }
}