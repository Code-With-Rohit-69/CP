import java.io.*;
import java.util.*;

/**
 * BKillDemodogs
 */
public class BKillDemodogs {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();
        int MOD = (int) (1e9 + 7);

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            
            // long ans = (1L * n * (n + 1) * (2 * n + 1)) / 6;
            // long mul = 0;

            // for(int i = 2; i <= n; i++) {
            //     mul += (1L * i * (i - 1));
            // }

            // ans += mul;

            // System.err.println("here : " + ans);

            // ans %= MOD;
            // ans = (ans * 2022) % MOD;

            /*
            
                = n(n+1)(2n+1)/6 + n(n+1)(n-1)/3
                = n(n+1)(4n-1)/6
            */

            long ans = n;
            ans = (ans * (n + 1)) % MOD;
            ans = (ans * (4L * n - 1)) % MOD;
            ans = (ans * 166666668) % MOD;
            ans = (ans * 2022) % MOD;

            out.append(ans + "\n");
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