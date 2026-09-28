import java.io.*;
import java.util.*;

/**
 * AKIsImportant
 */
public class AKIsImportant {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();

            List<Long> A = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                A.add(fr.nextLong());
            }

            long ans = 0L;

            if (n >= 2 * k - 1) {
                for (int i = k - 1; i <= n - k; i++) {
                    ans += A.get(i);
                }

                // remove elements from k - 1 to n - k
                A.subList(k - 1, n - k + 1).clear();
                n = A.size();
            }

            for (int i = 0; i <= n - k; i++) {
                ans += Math.max(A.get(i), A.get(n - 1 - i));
            }

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