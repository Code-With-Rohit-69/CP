import java.util.Arrays;
import java.util.Scanner;

public class A_Twin_Permutations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i < n; i++) {
                arr[i] = n - arr[i] + 1;
            }

            for (int i : arr) {
                System.out.print(i + " ");
            }

            System.out.println();

        }


        sc.close();
    }
}