import java.io.*;
import java.util.*;

/**
 * A23Numbers
 */
public class A23Numbers {

    private static final List<Integer> list = new ArrayList<>();
    private static final long LIMIT = 2_000_000_000L;

    static {
        for (long i = 1; i <= LIMIT; i *= 2) {
            for (long j = i; j <= LIMIT; j *= 3) {
                list.add((int) j);
            }
        }
        Collections.sort(list);
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int l = fr.nextInt(), r = fr.nextInt();

        int leftIndex = Collections.binarySearch(list, l);
        if (leftIndex < 0) {
            leftIndex = -leftIndex - 1;
        }
 
        int rightIndex = Collections.binarySearch(list, r);
        if (rightIndex < 0) {
            rightIndex = -rightIndex - 2;
        }

        int count = rightIndex - leftIndex + 1;
        
        if (count < 0) {
            count = 0;
        }

        System.out.println(count);

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