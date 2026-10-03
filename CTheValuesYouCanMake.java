import java.io.*;
import java.util.*;

/**
 * CTheValuesYouCanMake
 */
public class CTheValuesYouCanMake {

    /*
     * 
     * static boolean[] vis;
     * static boolean[][][] memo;
     * 
     * public static void dfs(int[] A, int index, int k, int s1, int s2) {
     * if(s1 > k) return;
     * 
     * if (s1 == k) {
     * vis[s2] = true;
     * // return;
     * }
     * 
     * if (index == A.length) {
     * return;
     * }
     * 
     * if(memo[index][s1][s2]) return;
     * memo[index][s1][s2] = true;
     * 
     * dfs(A, index + 1, k, s1, s2);
     * dfs(A, index + 1, k, s1 + A[index], s2);
     * dfs(A, index + 1, k, s1 + A[index], s2 + A[index]);
     * }
     * 
     */

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int k = fr.nextInt();

        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = fr.nextInt();
        }

        /*
        
            vis = new boolean[501];

            memo = new boolean[n][k + 1][k + 1];
            dfs(A, 0, k, 0, 0);

            int count = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i <= 500; i++) {
                if (vis[i]) {
                    count++;
                    sb.append(i + " ");
                }
            }

            System.out.println(count);
            System.out.println(sb);

        */

        boolean[][] dp = new boolean[k + 1][k + 1];
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            int a = A[i];
            for (int j = k; j >= 0; j--) {
                for (int l = k; l >= 0; l--) {
                    if (dp[j][l]) {
                        if (j + a <= k) {
                            dp[j + a][l] = true;
                        }
                        if (j + a <= k && l + a <= k) {
                            dp[j + a][l + a] = true;
                        }
                    }
                }
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= k; i++) {
            if (dp[k][i]) {
                count++;
                sb.append(i + " ");
            }
        }

        System.out.println(count);
        System.out.println(sb);

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
            if (c == -1)
                return -1;
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
            if (c == -1)
                return -1;
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
            if (c == -1)
                return null;
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
            if (c == -1)
                return -1;
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