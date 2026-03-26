import java.util.Scanner;

public class A_Desorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            boolean isSorted = true;
            int minDiff = Integer.MAX_VALUE;
            int minI = -1, minJ = -1;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (i >= 1 && arr[i] < arr[i - 1] && isSorted == true) {
                    isSorted = false;
                } else if (i >= 1 && arr[i] - arr[i - 1] < minDiff) {
                    minDiff = arr[i] - arr[i - 1];
                    minI = i - 1;
                    minJ = i;
                }
            }

            if (!isSorted) {
                System.out.println(0);
                continue;
            }

            int operations = 0;

            // while (arr[minI] <= arr[minJ]) {
            //     arr[minI]++;
            //     arr[minJ]--;

            //     operations++;
            // }

            operations = arr[minJ] - arr[minI];

            System.out.println((operations / 2) + 1);

        }

        sc.close();
    }
}