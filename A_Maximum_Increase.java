import java.util.Scanner;

public class A_Maximum_Increase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long len = 0;
        long curr = 1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                curr++;
            } else {
                len = Math.max(len, curr);
                curr = 1;
            }

        }

        len = Math.max(len, curr);

        System.out.println(len);

        sc.close();
    }
}