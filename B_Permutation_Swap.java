import java.util.Scanner;

public class B_Permutation_Swap {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            int k = (int) (1e9);

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                k = Math.min(k, Math.abs(arr[i] - (i + 1)));
            }

            System.out.println(k);

        }

        sc.close();
    }
}
