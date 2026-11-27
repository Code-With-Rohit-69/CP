import java.io.*;
import java.util.*;

/**
 * CHardProblem
 */
public class CHardProblem {

    static long INF = Long.MAX_VALUE;

    public static long dfs(int index, int prev, int n, int[] C, String[] S, String[] R) {
        if(index == n) return 0;

        long skip = INF, take = INF;

        String previous = "";

        if(prev != -1) {
            previous = (prev == 0) ? S[index - 1] : R[index - 1];
        }

        if(prev == -1 || previous.compareTo(S[index]) <= 0) {
            skip = dfs(index + 1, 0, n, C, S, R);
        }

        if(prev == -1 || previous.compareTo(R[index]) <= 0) {
            long cost = dfs(index + 1, 1, n, C, S, R);

            if(cost != INF) {
                take = C[index] + cost;
            }
        }

        return Math.min(skip, take);
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt();

        int[] C = new int[n];
        for(int i = 0; i < n; i++) C[i] = fr.nextInt();

        String[] S = new String[n];
        String[] R = new String[n];

        for(int i = 0; i < n; i++) {
            S[i] = fr.next();
            R[i] = new StringBuilder(S[i]).reverse().toString();
        }

        // long res = dfs(0, -1, n, C, S, R);

        // System.out.println(res == INF ? -1 : res);

        long[][] dp = new long[n + 1][3];

        for(long[] A : dp) Arrays.fill(A, INF);
        dp[n][0] = 0;
        dp[n][1] = 0;
        dp[n][2] = 0;

        for(int index = n - 1; index >= 0; index--) {
            for(int prev = -1; prev < 2; prev++) {
                long skip = INF, take = INF;

                String previous = "";

                if(prev != -1 && index > 0) {
                    previous = (prev == 0) ? S[index - 1] : R[index - 1];
                }

                if(index == 0 || prev == -1 || previous.compareTo(S[index]) <= 0) {
                    skip = dp[index + 1][1];
                }

                if(index == 0 || prev == -1 || previous.compareTo(R[index]) <= 0) {
                    long cost = dp[index + 1][2];

                    if(cost != INF) {
                        take = C[index] + cost;
                    }
                }

                dp[index][prev + 1] =  Math.min(skip, take);
            }
        }

        long res = (dp[0][0] == INF) ? -1 : dp[0][0];

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