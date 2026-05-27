import java.util.Arrays;
import java.util.Scanner;

public class B_Bogosort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr, (a, b) -> {
                return b - a;
            });

            for (Integer x : arr) {
                System.out.print(x + " ");
            }

            System.out.println();

        }

        sc.close();
    }
}
