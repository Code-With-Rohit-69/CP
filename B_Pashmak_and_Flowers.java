import java.util.HashMap;
import java.util.Scanner;

public class B_Pashmak_and_Flowers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Long, Long> map = new HashMap<>();

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();

            map.put(num, map.getOrDefault(num, 0L) + 1);

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        long diff = max - min;

        long count = 0;

        if (diff == 0) {
            count = (long) n * (n - 1) / 2;
        } else {
            count = map.get(min) * map.get(max);
        }

        System.out.println(diff + " " + count);

        sc.close();
    }
}