import java.util.Scanner;

public class B_NIT_Destroys_the_Universe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            int count = 0;
            int nonZero = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] != 0) {
                    nonZero++;
                } else {
                    if (nonZero > 0) {
                        count++;
                        nonZero = 0;
                    }
                }
            }

            if (nonZero > 0) {
                count++;
            }

            System.out.println(Math.min(count, 2));

        }

        sc.close();
    }
}