import java.util.*;
import java.io.*;

public class C_Raspberries {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();

            int[] arr = new int[n];
            // long product = 1L;

            int e = 0;
            int fives = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
                if ((arr[i] & 1) == 0)
                    e++;
                if (arr[i] % 5 == 0)
                    fives++;

                // product *= arr[i];
            }

            if (k == 2) {
                out.println(e > 0 ? 0 : 1);
                continue;
            }

            if (k == 5 && fives > 0) {
                out.println(0);
                continue;
            }

            if (k == 5) {
                int min = (int) (1e9);

                for (int i = 0; i < n; i++) {
                    min = Math.min(min, 5 - (arr[i] % 5));
                }

                out.println(min);
                continue;
            }

            if (k == 3) {

                int min = (int) (1e9);
                for (int i = 0; i < n; i++) {
                    int rem = arr[i] % 3;
                    int opNeeded = (rem == 0) ? 0 : (3 - rem);
                    min = Math.min(min, opNeeded);
                }
                out.println(min);

                continue;
            }

            if (k == 4) {

                int min = (int) (1e9);

                for (int i = 0; i < n; i++) {
                    min = Math.min(min, (4 - (arr[i] % 4)) % 4);
                }

                if (e >= 2) {
                    out.println(0);
                    continue;
                } else if (e == 1) {
                    min = Math.min(1, min);
                } else {
                    min = Math.min(2, min);
                }

                out.println(min);
            }

        }

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