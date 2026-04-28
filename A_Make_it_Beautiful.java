import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class A_Make_it_Beautiful {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                set.add(arr[i]);
            }

            if (set.size() == 1) {
                System.out.println("NO");
                continue;
            }

            Arrays.sort(arr);

            System.out.println("YES");

            for (int i = 0; i < n / 2; i++) {
                System.out.print(arr[i] + " " + arr[n - i - 1] + " ");
            }

            if((n & 1) != 0) {
                System.out.print(arr[n / 2]);
            }

            System.out.println();



        }

        sc.close();
    }
}