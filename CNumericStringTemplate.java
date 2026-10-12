import java.io.*;
import java.util.*;

/**
 * CNumericStringTemplate
 */
public class CNumericStringTemplate {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            int[] A = new int[n];

            for(int i = 0; i < n; i++)  A[i] = fr.nextInt();

            int m = fr.nextInt();

            while(m-- > 0) {
                String s = fr.next();

                if(s.length() != n) {
                    out.append("NO\n");
                    continue;
                }

                int[] freq = new int[26];
                Arrays.fill(freq, Integer.MIN_VALUE);

                HashMap<Integer, Character> map = new HashMap<>();

                boolean valid = true;

                for(int i = 0; i < s.length(); i++) {
                    int index = s.charAt(i) - 'a';
                    if(freq[index] == Integer.MIN_VALUE) {
                        freq[index] = A[i];
                    } else {
                        if(freq[index] != A[i]) {
                            valid = !valid;
                            break;
                        }
                    }

                    if(map.containsKey(A[i])) {
                        if(map.get(A[i]) != s.charAt(i)) {
                            valid = false;
                            break;
                        }
                    } else {
                        map.put(A[i], s.charAt(i));
                    }
                }

                out.append(valid ? "YES\n" : "NO\n");
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