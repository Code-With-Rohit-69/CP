import java.io.*;
import java.util.*;

/**
 * CBearAndStringDistance
 */
public class CBearAndStringDistance {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        int k = fr.nextInt();

        String s = fr.next();

        long max = 0;
        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);
            max += Math.max('z' - ch, ch - 'a');
        }

        if (max < k) {
            out.println(-1);
            out.flush();
            return;
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (i < n && k > 0) {
            char ch = s.charAt(i);

            int distanceToZ = 'z' - ch;
            int distanceToA = ch - 'a';

            int maxDiff = Math.max(distanceToZ, distanceToA);
            char maxChar = distanceToA > distanceToZ ? 'a' : 'z';

            if (maxDiff <= k) {
                k -= maxDiff;
                ans.append(maxChar);
            } else {
                if (ch + k <= 'z') {
                    ans.append((char) (ch + k));
                } else if (ch - k >= 'a') {
                    ans.append((char) (ch - k));
                }

                k = 0;
            }

            i++;

        }

        /*
         * 
         * s = "bear";
         * k = 26;
         * 
         * i = 0;
         * 
         * diff = 'z' - 'b' = 24
         * k -= 24; => k = 2
         * 
         * i = 1
         * 
         * diff = 'z' - 'e' = 21; // greater
         * 
         * 24 + 2 + 0 + 0
         * 
         * 7 +
         * 
         */

        while (i < n) {
            ans.append(s.charAt(i));
            i++;
        }

        out.println(ans);

        out.flush();

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
