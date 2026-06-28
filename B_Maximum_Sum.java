/**
 * B_Maximum_Sum
 */

import java.util.*;
import java.io.*;

public class B_Maximum_Sum {

    public static void main(String[] args) throws IOException {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();

            int[] arr = new int[n];
            long[] prefix = new long[n + 1];

            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
            }

            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                prefix[i + 1] = arr[i] + prefix[i];
            }
            
            long sum = 0;

            for (int i = 0; i <= k; i++) {
                int left = 2 * i;
                int right = k - i;

                int rightIndex = n - 1 - right;

                sum = Math.max(sum, prefix[rightIndex + 1] - prefix[left]);
            }

            out.println(sum);

        }

        out.flush();

    }
}

// 10 11 12 13 15 22
// sum = 83
// k = 2

// 83 - 21 = 62
// 62 - 22 = 40

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