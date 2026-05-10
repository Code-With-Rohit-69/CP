import java.util.Arrays;
import java.util.Scanner;

public class C_Less_or_Equal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        if (k == 0) {
            if (arr[0] == 1) {
                System.out.println(-1);
            } else {
                System.out.println(arr[0] - 1);
            }
        } else {
            int kth = arr[k - 1];

            if (k < n && kth == arr[k]) {
                System.out.println(-1);
            } else {
                System.out.println(kth);
            }
        }

        sc.close();
    }
}