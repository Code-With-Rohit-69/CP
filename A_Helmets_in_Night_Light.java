import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class A_Helmets_in_Night_Light {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int p = sc.nextInt();

            ArrayList<int[]> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();

                list.add(new int[] { num, 0 });
            }

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();

                int[] arr = list.get(i);
                arr[1] = num;
            }

            Collections.sort(list, (a, b) -> Integer.compare(a[1], b[1]));

            int index = 0;
            int remaining = n - 1;
            long total = p;

            while (remaining > 0 && index < list.size()) {
                int[] curr = list.get(index);
                int limit = curr[0];
                int cost = curr[1];

                if (cost >= p) {
                    break;
                }

                int take = Math.min(remaining, limit);
                total += (long) take * cost;
                remaining -= take;
                index++;
            }

            if (remaining > 0) {
                total += (long) remaining * p;
            }

            System.out.println(total);

        }

        sc.close();
    }
}