import java.util.Arrays;
import java.util.Scanner;

public class D_Balanced_Round {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int count = 1;
            int min = Integer.MAX_VALUE;

            for(int i = 1; i < n; i++) {
                if(arr[i] - arr[i-1] <= k) {
                    count++;
                } else {
                    min = Math.min(min, n - count);
                    count = 1;
                }
            }

            min = Math.min(min, n - count);
            System.out.println(min);

        }

        sc.close();
    }
}