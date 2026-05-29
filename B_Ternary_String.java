import java.util.HashSet;
import java.util.Scanner;

public class B_Ternary_String {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            String s = sc.next();
            int n = s.length();

            int[] freq = new int[4];

            int l = 0;
            int ans = Integer.MAX_VALUE;

            for (int r = 0; r < n; r++) {
                char ch = s.charAt(r);

                freq[ch - '0']++;

                while (freq[1] > 0 && freq[2] > 0 && freq[3] > 0 && l < r) {
                    ans = Math.min(ans, r - l + 1);
                    freq[s.charAt(l) - '0']--;
                    l++;
                }

            }

            System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
        }


        sc.close();
    }
}