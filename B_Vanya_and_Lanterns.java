import java.util.Arrays;
import java.util.Scanner;

public class B_Vanya_and_Lanterns {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        double max = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, arr[i + 1] - arr[i]);
        }

        max = max / 2.0;

        max = Math.max(max, Math.max(arr[0], l - arr[n - 1]));

        System.out.println(max);

        sc.close();
    }
}

/*

    15 5 3 7 9 14 0

    0 3 5 7 9 14 15

*/