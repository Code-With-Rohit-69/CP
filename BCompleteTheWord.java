import java.io.*;
import java.util.*;

/**
 * BCompleteTheWord
 */
public class BCompleteTheWord {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        String s = fr.next();

        int n = s.length();
        char[] A = s.toCharArray();

        for (int i = 0; i <= n - 26; i++) {

            int[] freq = new int[26];
            boolean ok = true;

            for (int j = i; j < i + 26; j++) {
                char ch = A[j];

                if (ch == '?')
                    continue;

                if (freq[ch - 'A'] > 0) {
                    ok = false;
                    break;
                }

                freq[ch - 'A']++;
            }

            if (!ok)
                continue;

            int index = 0;

            for (int j = i; j < i + 26; j++) {
                if (A[j] == '?') {

                    while (index < 26 && freq[index] > 0) {
                        index++;
                    }

                    A[j] = (char) ('A' + index);
                    freq[index]++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (A[j] == '?')
                    A[j] = 'A';
            }

            System.out.println(new String(A));
            return;
        }

        System.out.println(-1);
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