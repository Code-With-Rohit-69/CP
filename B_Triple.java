import java.util.HashMap;
import java.util.Scanner;

public class B_Triple {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Long, Integer> freq = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long num = sc.nextLong();
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            boolean found = false;
            for (long key : freq.keySet()) {
                if (freq.get(key) >= 3) {
                    found = true;
                    System.out.println(key);
                    break;
                }
            }

            if (!found) {
                System.out.println(-1);
            }

        }

        sc.close();
    }
}