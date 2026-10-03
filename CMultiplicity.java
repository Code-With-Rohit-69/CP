import java.io.*;
import java.util.*;

/**
 * CMultiplicity
 */
public class CMultiplicity {

    static int MOD = (int) (1e9 + 7);

    /*
     * 
     * public static int dfs(int index, int size, int[] A, int[][] memo) {
     * if(index == A.length) {
     * return 0;
     * }
     * 
     * if(memo[index][size] != -1) {
     * return memo[index][size];
     * }
     * 
     * int count = 0;
     * 
     * // skip current element
     * 
     * count += dfs(index + 1, size, A, memo) % MOD;
     * 
     * // include current element
     * 
     * if(A[index] % size == 0) {
     * count += (1 + dfs(index + 1, size + 1, A, memo)) % MOD;
     * }
     * 
     * memo[index][size] = count % MOD;
     * return memo[index][size];
     * }
     * 
     */

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        
        int n = fr.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = fr.nextInt();
        }

        /*
        int[][] memo = new int[n + 1][n + 1];

        for(int[] B : memo) {
            Arrays.fill(B, -1);
        }

        int count = dfs(0, 1, A, memo);

        System.out.println(count);
        
        */
       /*

        int[][] dp = new int[n + 1][n + 2];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = n; j >= 1; j--) {
                dp[i][j] = dp[i + 1][j] % MOD;

                if(A[i] % j == 0) {
                    dp[i][j] += (1 + dp[i + 1][j + 1]) % MOD;
                }
            }
        }

        System.out.println(dp[0][1]);

        */

        int[] dp = new int[n + 2];

        for(int i = n - 1; i >= 0; i--) {
            int[] curr = new int[n + 2];
            for(int j = n; j >= 1; j--) {
                curr[j] = dp[j] % MOD;

                if(A[i] % j == 0) {
                    curr[j] += (1 + dp[j + 1]) % MOD;
                }
            }

            dp = curr;
        }

        System.out.println(dp[1]);

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