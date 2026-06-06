import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C_1_We_Be_Flipping_Easy_Version {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            int neg = 0;
            List<Integer> pos = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] < 0) {
                    neg++;
                } else if (arr[i] > 0) {
                    pos.add(i);
                }
            }

            if (neg == n) {
                System.out.println(0);
                System.out.println();
            } else if (neg == 0) {
                System.out.println(1);
                System.out.println(n);
            } else {
                int k = 2 * pos.size();

                if (!pos.isEmpty() && pos.get(0) == 0) {
                    k--;
                }

                System.out.println(k);

                for (int index : pos) {
                    System.out.print(index + 1 + " ");
                }
                for (int i = pos.size() - 1; i >= 0; i--) {
                    if (pos.get(i) == 0) {
                        continue;
                    }

                    System.out.print((pos.get(i)) + " ");
                }
                System.out.println();
            }

        }

        sc.close();
    }
}