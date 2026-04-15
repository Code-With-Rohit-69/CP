import java.util.Scanner;

public class D_Odd_Queries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            long[] arr = new long[n];
            long[] prefix = new long[n];
            long sum = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                sum += arr[i];

                if(i == 0) {
                    prefix[i] = arr[i];
                } else {
                    prefix[i] = prefix[i - 1] + arr[i];
                }

            }

            while (q-- > 0) {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;
                int k = sc.nextInt();

                int nq = r - l + 1;
                
                long rangeSum = 0;

                if(l > 0) {
                    rangeSum = prefix[r] - prefix[l - 1];
                } else {
                    rangeSum = prefix[r];
                }

                long newSum = (sum - rangeSum) + (k * nq);

                if ((newSum & 1) == 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }

            }

        }

        sc.close();
    }
}