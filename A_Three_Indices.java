import java.util.Scanner;

public class A_Three_Indices {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] left = new int[n];
            left[0] = -1;

            int minIndex = 0;

            for(int i = 1; i < n; i++) {
                if(arr[i] > arr[minIndex]) {
                    left[i] = minIndex;
                } else {
                    left[i] = -1;
                    minIndex = i;
                }
            }

            int[] right = new int[n];
            right[n - 1] = -1;

            minIndex = n - 1;

            for(int i = n - 2; i >= 0; i--) {
                if(arr[i] > arr[minIndex]) {
                    right[i] = minIndex;
                } else {
                    right[i] = -1;
                    minIndex = i;
                }
            }

            boolean found = false;

            for (int i = 1; i < n - 1; i++) {
                if (left[i] != -1 && right[i] != -1) {
                    System.out.println("YES");
                    System.out.println((left[i] + 1) + " " + (i + 1) + " " + (right[i] + 1));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}