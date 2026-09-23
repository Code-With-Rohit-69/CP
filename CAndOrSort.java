import java.io.*;
import java.util.*;

/**
 * CAndOrSort
 */
public class CAndOrSort {

    public static int solve(String s, int n) {

        // base case

        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
                isSorted = false;
                break;
            }
        }
        if (isSorted)
            return 0;

        int[] suffix = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = (i < n - 1) ? (s.charAt(i + 1) - '0') + suffix[i + 1] : 0;
        }

        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            prefix[i] = (i > 0) ? (s.charAt(i - 1) - '0') + prefix[i - 1] : 0;
        }

        int min = Integer.MAX_VALUE;

        int totalZeros = 0;
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0')
                totalZeros++;
            else
                totalOnes++;
        }

        if (s.charAt(0) == '1') {
            return totalZeros;
        }

        if (s.charAt(0) == '0') {
            min = Math.min(min, totalOnes);
        }

        if (s.charAt(0) == '0') {
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == '1') {
                    int onesLeft = prefix[i];
                    int zerosRight = (n - i - 1) - suffix[i];

                    min = Math.min(min, onesLeft + zerosRight);
                }
            }
        }
        return min;

    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int t = fr.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = fr.nextInt();
            String s = fr.next();

            int res = solve(s, n);

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