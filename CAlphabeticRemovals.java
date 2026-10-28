import java.io.*;
import java.util.*;

/**
 * CAlphabeticRemovals
 */
public class CAlphabeticRemovals {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int k = fr.nextInt();

        String s = fr.next();

        int[][] freq = new int[26][2];

        // 0 -> original
        // 1 -> updated
        
        for(char ch : s.toCharArray()) {
            int index = ch - 'a';

            freq[index][0]++;
            freq[index][1]++;
        }

        for(int i = 0; i < 26 && k > 0; i++) {
            if(freq[i][0] == 0) continue;

            int f = freq[i][1];

            int min = Math.min(f, k);
            freq[i][1] -= min;
            k -= min;
        }

        StringBuilder out = new StringBuilder();

        for(char ch : s.toCharArray()) {
            int index = ch - 'a';

            if(freq[index][0] == freq[index][1]) {
                out.append(ch);
            } else {
                freq[index][1]++;
            }
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