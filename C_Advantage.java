import java.util.Scanner;

public class C_Advantage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            int max = -1, secondMax = -1;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

                if (arr[i] >= max) {
                    secondMax = max;
                    max = arr[i];
                } else if (arr[i] > secondMax && arr[i] != max) {
                    secondMax = arr[i];
                }
            }

            for (int i = 0; i < n; i++) {
                if (arr[i] == max) {
                    System.out.print(arr[i] - secondMax + " ");
                } else {
                    System.out.print(arr[i] - max + " ");
                }
            }

            System.out.println();

        }

        sc.close();
    }
}