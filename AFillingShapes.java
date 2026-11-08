import java.util.*;

public class AFillingShapes {

    static int[] memo;

    public static int dfs(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;

        if (memo[n] != -1) return memo[n];

        return memo[n] = 2 * dfs(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // memo = new int[n + 1];
        // Arrays.fill(memo, -1);

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 0;

        for(int i = 2; i <= n; i++) {
            dp[i] = 2 * dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}