import java.io.*;
import java.util.*;

/**
 * AVacations
 */
public class AVacations {

    public static int dfs(int index, int prev, int n, int[] A) {
        if(index == n) return 0;

        int count = 0;

        if(A[index] == 0 || A[index] == prev) {
            count = 1 + dfs(index + 1, 0, n, A);
        } 
        else if(A[index] == 1 || A[index] == 2) {
            count = dfs(index + 1, A[index], n, A);
        } 
        else {
            if(prev == 1) count = dfs(index + 1, 2, n, A);
            else if(prev == 2) count = dfs(index + 1, 1, n, A);
            else count = Math.min(dfs(index + 1, 1, n, A),
                                dfs(index + 1, 2, n, A));
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int[] A = new int[n];

        for(int i = 0; i < n; i++) A[i] = fr.nextInt();

        int[] dp = new int[4];

        for(int index = n - 1; index >= 0; index--) {
            int[] curr = new int[4];

            for(int prev = 0; prev < 4; prev++) {
                int count = 0;

                if(A[index] == 0 || A[index] == prev) {
                    count = 1 + dp[0];
                } 
                else if(A[index] == 1 || A[index] == 2) {
                    count = dp[A[index]];
                } 
                else {
                    if(prev == 1) count = dp[2];
                    else if(prev == 2) count = dp[1];
                    else count = Math.min(dp[1], dp[2]);
                }

                curr[prev] = count;
            }

            dp = curr;
        }

        System.out.println(dp[0]);
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