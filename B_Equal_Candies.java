import java.util.Scanner;

public class B_Equal_Candies {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int min = (int) (1e9);

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                min = Math.min(min, arr[i]);
            }

            long eated = 0;

            for (int i = 0; i < arr.length; i++) {
                eated += arr[i] - min;
            }

            System.out.println(eated);

        }

        sc.close();
    }
}