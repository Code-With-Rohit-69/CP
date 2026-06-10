import java.util.HashMap;
import java.util.Scanner;

public class B_Array_Cloning_Technique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt();

            long[] arr = new long[n];
            HashMap<Long, Integer> map = new HashMap<>();
            int maxFreq = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(arr[i]));
            }

            if (map.size() == 1) {
                System.out.println(0);
                continue;
            }

            if (n == 2 && map.size() == 2) {
                System.out.println(2);
                continue;
            }

            long total = 0;
            while (maxFreq < n) {  
                total++;  
                if (maxFreq * 2 <= n) {
                    total += maxFreq;  
                    maxFreq *= 2; 
                } else {
                    total += n - maxFreq;  
                    maxFreq = n;  
                }
            }

            System.out.println(total);

        }

        sc.close();
    }
}

/*
 * 
 * nums = [2, 5, 7, 6, 3]
 * max freq = 1
 * 
 * +1 clone
 * [2, 2, 7, 6, 3] -> only +1 swap
 * +1 clone
 * [2, 2, 2, 2, 3] -> +2 swaps
 * +1 clone
 * [2, 2, 2, 2, 2] -> +1 swap
 * 
 * total = 7
 * 
 */