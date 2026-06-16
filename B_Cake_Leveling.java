import java.util.Scanner;

public class B_Cake_Leveling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextLong();
            }

            long sum = 0;
            sum += arr[0];

            System.out.print(arr[0] + " ");

            for (int i = 1; i < n; i++) {
                sum += arr[i];
                arr[i] = Math.min(sum / (i + 1), arr[i - 1]);

                System.out.print(arr[i] + " ");
            }

            System.out.println();


        }

        sc.close();
    }
}