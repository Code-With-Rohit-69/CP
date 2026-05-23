import java.util.Arrays;
import java.util.Scanner;

public class B_Interesting_drink {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int q = sc.nextInt();

        for (int k = 0; k < q; k++) {
            int mi = sc.nextInt();

            int i = 0;
            int j = n - 1;

            int res = -1;

            while (i <= j) {
                int mid = i + (j - i) / 2;

                if(arr[mid] <= mi) {
                    res = mid;
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }

            System.out.println(res + 1);

        }


        sc.close();
    }
}