import java.io.*;
import java.util.*;

/**
 * C101
 * 
 * see i have to find best start and ending index
 * 
 * if 1 is already seen and next we have seen -1 we termed it as 0 but before it
 * we also termed it as ending index for safe play
 * 
 * if there is no 1 seen before and we are at -1 we termed it as 1 so starting
 * index is current index
 * 
 * 
 */
public class C101 {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
            }

            int bestLeft = -1;
            int bestRight = -1;

            int l = -1;
            int e = -1;

            for (int i = 0; i < n; i++) {
                int x = arr[i];

                if (x == 1) {
                    if (l == -1) {
                        l = i;
                    } else {
                        e = i;

                        if (e - l + 1 > bestRight - bestLeft + 1) {
                            bestLeft = l;
                            bestRight = e;
                        }

                        l = i;
                        e = -1;
                    }
                } else if (x == -1) {
                    if (l == -1) {
                        l = i;
                    } else {
                        e = i;

                        if (e - l + 1 > bestRight - bestLeft + 1) {
                            bestLeft = l;
                            bestRight = e;
                        }

                        e = -1;
                    }
                }
            }

            if (l != -1 && bestLeft == -1) {
                bestLeft = l;
            }

            // out.append ("length: " + (bestRight - bestLeft + 1) + "\n");

            for (int i = 0; i < n; i++) {
                if (bestLeft != -1 && (i == bestLeft || i == bestRight)) {
                    out.append("1 ");
                } else if (i > bestLeft && i < bestRight && bestLeft != -1 && bestRight != -1) {
                    out.append("0 ");
                } else {
                    out.append(((arr[i] == -1) ? 0 : arr[i]) + " ");
                }
            }

            out.append("\n");

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