import java.util.HashSet;
import java.util.Scanner;

public class D_Distinct_Split {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            String s = sc.next();
            
            int[] left = new int[n];
            int[] right = new int[n];
            
            HashSet<Character> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                set.add(s.charAt(i));
                left[i] = set.size();
            }

            set = new HashSet<>();

            for (int i = n - 1; i >= 0; i--) {
                set.add(s.charAt(i));
                right[i] = set.size();
            }

            int max = 0;

            for (int i = 0; i < n - 1; i++) {
                max = Math.max(max, left[i] + right[i + 1]);
            }

            System.out.println(max);

        }   

        sc.close();
    }
}