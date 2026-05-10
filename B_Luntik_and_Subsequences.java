import java.util.HashMap;
import java.util.Scanner;

public class B_Luntik_and_Subsequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int sum = 0;

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                sum += num;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int count = 0;

            if (map.containsKey(1)) {
                count += map.get(1);
            }

            if(map.containsKey(0)) {
                count += map.get(0);

                if (n > 2) {
                    count++;
                }

            }

            System.out.println(count);


        }

        sc.close();
    }
}