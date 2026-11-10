import java.io.*;
import java.util.*;

/**
 * AShuffleHashing
 */
public class AShuffleHashing {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int T = fr.nextInt();

        while(T-- > 0) {
            String s = fr.next();
            String t = fr.next();

            int[] freq = new int[26];

            for(char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            if(s.length() > t.length()) {
                out.append("NO").append("\n");
                continue;
            }

            boolean possible = false;
            int n = s.length();
            int m = t.length();

            for (int i = 0; i <= m - n; i++) {
                int[] tFreq = new int[26];
                for (int j = i; j < i + n; j++) {
                    tFreq[t.charAt(j) - 'a']++;
                }

                if (Arrays.equals(freq, tFreq)) {
                    possible = true;
                    break;
                }
            }

            out.append(possible ? "YES" : "NO").append("\n");
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