import java.util.*;

public class B_Another_Sorting_Problem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            int maxDiff = -1;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

                if(i > 0) {
                    if (arr[i] < arr[i - 1]) {
                        maxDiff = Math.max(maxDiff, arr[i - 1] - arr[i]);
                    }
                }
            }

            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i - 1]) {
                    arr[i] += maxDiff;
                }
            }

            boolean isValid = true;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isValid = false;
                    break;
                }
            }

            System.out.println(isValid ? "YES" : "NO");

        }

        sc.close();
    }
}