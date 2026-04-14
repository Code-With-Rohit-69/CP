import java.util.Scanner;

public class B_Good_Kid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            int min = Integer.MAX_VALUE;
            long mul = 1;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                min = Math.min(min, arr[i]);
            }

            boolean used = false;

            for (int i = 0; i < n; i++) {
                if (arr[i] == min && !used) {
                    used = true;
                    arr[i] += 1;
                }
                mul *= arr[i];
            }

            System.out.println(mul);

        }

        sc.close();
    }
}