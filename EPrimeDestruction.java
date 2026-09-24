import java.io.*;
import java.util.*;

/**
 * EPrimeDestruction
 */
public class EPrimeDestruction {

    static int MAX = 200005;
    static int[] prime = new int[MAX];

    public static void seive() {
        for(int p = 2; p < MAX; p++) {
            if(prime[p] == 0) {
                for(int j = p; j < MAX; j += p) {
                    if(prime[j] == 0) {
                        prime[j] = p;
                    }
                }
            }
        }
    }

    public static long solve(int[] A, int n, int k) {
        long[] dp = new long[n + 1];

        for(int i = k + 1; i <= n; i++) {
            dp[i] = Long.MAX_VALUE;

            int temp = i;

            while(temp > 1) {
                int p = prime[temp];

                long currCost = 1 + (long) p * dp[i / p];

                dp[i] = Math.min(dp[i], currCost);

                while(temp % p == 0) temp /= p;
            }
        }

        long total = 0;

        for(int x : A) {
            total += dp[x];
        }

        return total;

    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();
        seive();

        while(t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();

            int[] A = new int[n];

            for(int i = 0; i < n; i++) A[i] = fr.nextInt();

            long res = solve(A, n, k);

            out.append(res + "\n");
        }

        System.out.println(out);
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