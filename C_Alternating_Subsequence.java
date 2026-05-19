import java.util.Scanner;

public class C_Alternating_Subsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            long ans = 0;
            long mx = arr[0];

            for (int i = 1; i < n; i++) {

                if ((arr[i] > 0) == (arr[i - 1] > 0)) {
                    mx = Math.max(mx, arr[i]);
                } else {
                    ans += mx;
                    mx = arr[i];
                }
            }

            ans += mx;

            System.out.println(ans);

        }

        sc.close();
    }
}
