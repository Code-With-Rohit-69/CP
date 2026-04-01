import java.util.*;

public class A_Doremy_s_Paint_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), even = 0, odd = 0;
            int[] arr = new int[n];
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                set.add(arr[i]);
                if((arr[i] & 1) == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            if(set.size() > 2) {
                System.out.println("No");
                continue;
            }

            if (Math.abs(even - odd) > 1 && (even != 0 && odd != 0)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }

        sc.close();
    }
}