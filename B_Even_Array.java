import java.util.Scanner;

public class B_Even_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int count = 0;

            for (int i = 0; i < n; i++) {

                // if already correct → skip
                if (arr[i] % 2 == i % 2)
                    continue;

                int index = -1;

                for (int j = i + 1; j < n; j++) {

                    if (arr[j] % 2 != j % 2) {

                        if ((arr[i] % 2) == (j % 2) && (arr[j] % 2) == (i % 2)) {
                            index = j;
                            break;
                        }
                    }
                }

                if (index == -1) {
                    count = -1;
                    break;
                }

                // swap
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;

                count++;
            }

            System.out.println(count);

        }

        sc.close();
    }
}