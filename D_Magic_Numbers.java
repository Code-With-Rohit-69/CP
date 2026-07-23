import java.util.Arrays;
import java.util.Scanner;

public class D_Magic_Numbers {

    static int m;
    static int d;
    static final int MOD = (int) (1e9 + 7);
    static long[][] memo;

    public static long dfs(String s, int pos, int rem, int tight) {

        if (pos == s.length())
            return rem == 0 ? 1 : 0;

        if (tight == 0 && memo[pos][rem] != -1)
            return memo[pos][rem];

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
        long ans = 0;

        if ((pos & 1) == 1) {

            if (d <= limit) {

                int nt = (tight == 1 && d == limit) ? 1 : 0;
                int nr = (rem * 10 + d) % m;

                ans = dfs(s, pos + 1, nr, nt);
            }

        } else {

            for (int digit = 0; digit <= limit; digit++) {

                if (digit == d)
                    continue;

                if (pos == 0 && digit == 0)
                    continue;

                int nt = (tight == 1 && digit == limit) ? 1 : 0;
                int nr = (rem * 10 + digit) % m;

                ans += dfs(s, pos + 1, nr, nt);
            }
        }

        ans %= MOD;

        if (tight == 0)
            memo[pos][rem] = ans;

        return ans;
    }

    public static long solve(String s) {
        int len = s.length();

        memo = new long[len][m];

        for (long[] A : memo) {
            Arrays.fill(A, -1);
        }

        return dfs(s, 0, 0, 1); // string, index, created number, tightness
    }

    public static String minusOne(String s) {
        char[] arr = s.toCharArray();

        int i = arr.length - 1;

        while (i >= 0 && arr[i] == '0') {
            arr[i] = '9';
            i--;
        }

        arr[i]--;

        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        d = sc.nextInt();

        String a = sc.next();
        String b = sc.next();

        String left = minusOne(a);

        long c1 = solve(left);
        long c2 = solve(b);

        System.out.println((c2 - c1 + MOD) % MOD);

        sc.close();
    }
}