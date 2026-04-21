import java.util.Scanner;

public class C_Can_I_Square {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += sc.nextLong();
            }

            long sqrt = (long) Math.sqrt(sum);
            if (sqrt * sqrt == sum) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}