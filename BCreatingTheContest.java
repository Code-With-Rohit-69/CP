import java.io.*;
import java.util.*;

/**
 * BCreatingTheContest
 */
public class BCreatingTheContest {

    /*

    public static int dfs(int index, int prev, int n, int[] A) {
        if(index == n) return 0;

        int skip = dfs(index + 1, prev, n, A);
        int take = 0;

        if(prev == -1 || A[index] <= 2 * A[prev]) {
            take = 1 + dfs(index + 1, index, n, A);
        }

        return Math.max(skip, take);
    }

     */

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int[] A = new int[n];

        for(int i = 0; i < n; i++) A[i] = fr.nextInt();

        // int[] dp = new int[n + 1];

        // for(int i = n - 1; i >= 0; i--) {
        //     for(int j = -1; j < n; j++) {
        //         int skip = dp[j + 1];

        //         int take = 0;

        //         if(j == -1 || A[i] <= 2 * A[j]) {
        //             take = 1 + dp[i + 1];
        //         }

        //         dp[j + 1] = Math.max(skip, take);
        //     }
        // }

        int ans = 1;
        int curr = 1;

        for(int i = 1; i < n; i++) {

            if(A[i] <= 2L * A[i - 1]) {
                curr++;
            } else {
                curr = 1;
            }

            ans = Math.max(ans, curr);
        }

        System.out.println(ans);

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