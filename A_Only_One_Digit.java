import java.util.*;

public class A_Only_One_Digit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = Integer.MAX_VALUE;

            while (n > 0) {
                int digit = n % 10;
                ans = Math.min(ans, digit);
                n /= 10;
            }

            System.out.println(ans);

        }

        sc.close();
    }
}