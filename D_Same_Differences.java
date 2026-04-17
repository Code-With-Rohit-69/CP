import java.util.HashMap;
import java.util.Scanner;

public class D_Same_Differences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                int d = arr[i] - i;
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            // System.out.println(map);

            long count = 0;

            for (int i = 0; i < n; i++) {
                count += map.get(arr[i] - i) - 1;
            }

            System.out.println(count / 2);

        }

        sc.close();
    }
}