import java.util.HashMap;
import java.util.Scanner;

public class A_Convergence {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();

            int max = 0;

            for(int i = 0; i < n; i++) {
                int num = sc.nextInt();

                map.put(num, map.getOrDefault(num, 0) + 1);

                max = Math.max(max, map.get(num));
            }

            int rest = n - max;

            System.out.println((rest + 1) / 2);

        }

        sc.close();
    }
}
