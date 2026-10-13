import java.io.*;
import java.util.*;

/**
 * BPrefix
 */
public class BPrefix {

    public static long dfs(long[] A, int index, long prefix, Map<String, Long> memo) {
        if (index == A.length) {
            return Integer.MIN_VALUE;
        }

        String key = index + "," + prefix;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long val = A[index];

        long choice1 = val - prefix;
        long choice2 = val;
        long choice3 = val + prefix;

        long max = Math.max(choice1, Math.max(choice2, choice3));

        if (index == A.length - 1) {
            memo.put(key, max);
            return max;
        }

        long next1 = dfs(A, index + 1, prefix + choice1, memo);
        long next2 = dfs(A, index + 1, prefix + choice2, memo);
        long next3 = dfs(A, index + 1, prefix + choice3, memo);

        long res = Math.max(max, Math.max(next1, Math.max(next2, next3)));
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            long[] A = new long[n];

            for (int i = 0; i < n; i++)
                A[i] = fr.nextLong();

            Map<String, Long> memo = new HashMap<>();
            long res = Math.max(A[0], dfs(A, 1, A[0], memo));

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