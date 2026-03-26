import java.util.Scanner;

public class A_Unit_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int negatives = 0;
            int sum = 0;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                negatives = arr[i] < 0 ? negatives + 1 : negatives;
                sum += arr[i];
            }

            int postives = n - negatives;

            if (negatives % 2 == 0 && postives != 0) {
                System.out.println(0);
            } else {
                int res = Math.min(Math.abs(negatives - postives), Math.abs(sum));
                System.out.println(res);
            }

        }

        sc.close();
    }
}