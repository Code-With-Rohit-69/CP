import java.util.Arrays;
import java.util.Scanner;

public class A_Two_Substrings {
    static int n;
    static int[][][] memo;

    public static int dfs(String s, int i, int ab, int ba) {

        if (ab == 1 && ba == 1) {
            return 1;
        }

        if (i >= n - 1) {
            return 0;
        }

        if (memo[i][ab][ba] != -1) {
            return memo[i][ab][ba];
        }

        int ans = 0;

        String sub = s.substring(i, i + 2);

        if (sub.equals("AB")) {
            ans |= dfs(s, i + 2, 1, ba);
        }

        if (sub.equals("BA")) {
            ans |= dfs(s, i + 2, ab, 1);
        }

        ans |= dfs(s, i + 1, ab, ba);

        return memo[i][ab][ba] = ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        n = s.length();

        memo = new int[n + 1][2][2];

        for (int[][] arr : memo) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }

        int result = dfs(s, 0, 0, 0);

        System.out.println(result == 1 ? "YES" : "NO");

        sc.close();
    }
}