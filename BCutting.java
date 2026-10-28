import java.io.*;
import java.util.*;

/**
 * BCutting
 */

public class BCutting {

    public static int dfs(int index, int diff, int B, int[] A, int[][][] memo) {

        if(index >= A.length) return 0;

        if (memo[index][diff + A.length][B] != -1) {
            return memo[index][diff + A.length][B];
        }

        int newDiff = A[index] % 2 == 1 ? diff + 1 : diff - 1;

        int skipCutting = dfs(index + 1, newDiff, B, A, memo);

        int cut = Integer.MIN_VALUE;
        int cost = 0;

        if (newDiff == 0 && index + 1 < A.length) {
            cost = Math.abs(A[index] - A[index + 1]);

            if (B >= cost) {
                cut = 1 + dfs(index + 1, 0, B - cost, A, memo);
            }
        }

        return memo[index][diff + A.length][B] = Math.max(skipCutting, cut);
    }

    public static int tabulation(int[] A, int B) {
        int n = A.length;
        int[][][] dp = new int[n + 1][2 * n + 1][B + 1];

        for(int i = n - 1; i >= 0; i--) { // current index
            for(int j = 0; j <= 2 * n; j++) { // odd even diff
                int diff = j - n;

                for(int k = 0; k <= B; k++) {
                    int newDiff = A[i] % 2 == 1 ? diff + 1 : diff - 1;
                    int skip = 0;

                    if (newDiff >= -n && newDiff <= n) {
                        skip = dp[i + 1][newDiff + n][k];
                    }

                    int cut = Integer.MIN_VALUE;
                    int cost = 0;

                    if (newDiff == 0 && i + 1 < A.length) {
                        cost = Math.abs(A[i] - A[i + 1]);

                        if (k >= cost) {
                            cut = 1 + dp[i + 1][n][k - cost];
                        }
                    }

                    dp[i][j][k] = Math.max(skip, cut);
                }
            }
        }

        return dp[0][n][B];
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt(), B = fr.nextInt();

        int[] A = new int[n];

        for(int i = 0; i < n; i++) A[i] = fr.nextInt();

        // int[][][] memo = new int[n][2 * n + 1][B + 1];

        // for (int[][] row : memo) {
        //     for (int[] col : row) {
        //         Arrays.fill(col, -1);
        //     }
        // }

        int res = tabulation(A, B);

        System.out.println(res);

    }    
}

class FastReader {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;

    private int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buffer);
            ptr = 0;
            if (len <= 0)
                return -1;
        }
        return buffer[ptr++];
    }

    int nextInt() throws IOException {
        int c;
        while ((c = read()) <= ' ') {
            if (c == -1) return -1;
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int num = 0;
        while (c > ' ') {
            num = num * 10 + (c - '0');
            c = read();
        }
        return num * sign;
    }

    long nextLong() throws IOException {
        int c;
        while ((c = read()) <= ' ') {
            if (c == -1) return -1;
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        long num = 0;
        while (c > ' ') {
            num = num * 10 + (c - '0');
            c = read();
        }
        return num * sign;
    }

    String next() throws IOException {
        int c;
        while ((c = read()) <= ' ') {
            if (c == -1) return null;
        }
        StringBuilder sb = new StringBuilder();
        while (c > ' ') {
            sb.append((char) c);
            c = read();
        }
        return sb.toString();
    }

    double nextDouble() throws IOException {
        int c;
        while ((c = read()) <= ' ') {
            if (c == -1) return -1;
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        double num = 0;
        while (c > ' ' && c != '.') {
            num = num * 10 + (c - '0');
            c = read();
        }
        if (c == '.') {
            double div = 10;
            while ((c = read()) > ' ') {
                num += (c - '0') / div;
                div *= 10;
            }
        }
        return num * sign;
    }
}