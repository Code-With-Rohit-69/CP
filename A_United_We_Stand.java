import java.util.ArrayList;
import java.util.Scanner;

public class A_United_We_Stand {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            int max = (int) (-1e9);

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                max = Math.max(a[i], max);
            }

            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> c = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (a[i] == max) {
                    c.add(a[i]);
                } else {
                    b.add(a[i]);
                }
            }

            if (b.size() == 0) {
                System.out.println(-1);
                continue;
            }

            System.out.println(b.size() + " " + c.size());

            for (int num : b) {
                System.out.print(num + " ");
            }

            System.out.println();

            for (int num : c) {
                System.out.print(num + " ");
            }

            System.out.println();

        }

        sc.close();
    }
}