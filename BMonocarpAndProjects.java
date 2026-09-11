
import java.io.*;
import java.util.*;

/**
 * BMonocarpAndProjects
 */
public class BMonocarpAndProjects {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int t = fr.nextInt();
        
        while (t-- > 0) {
            long x = fr.nextLong();
            long y = fr.nextLong();
            long k = fr.nextLong();

            long d = y - x;

            long add = 0;

            // Phase 1: Simulate while employees (x) <= difference (d)
            while (k > 0 && x <= d) {
                add += d % x;
                x++;
                k--;
            }

            // Phase 2: For all remaining months, x > d, so d % x = d
            if (k > 0) {
                add += k * d;
            }

            sb.append(add + "\n");

        }
        System.out.print(sb);
        
    }
    
}

/*

    d = y - x
    y = x + d;

    (x + i) % (y + i)
    (x + i) % ((x + i) + d)
    d % (x + i)

    x = 3, y = 10

    10 % 3 = 1
    11 % 4 = 3
    12 % 5 = 2
    13 % 6 = 1
    14 % 7 = 0
    15 % 8 = 7
    
    x / y
    x + 1 / y + 1
    x + 2 / y + 2
    x + 3 / y + 3
    .....
    .....
    .....
    .....
    x + k / y + k

    the difference will always same

*/


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