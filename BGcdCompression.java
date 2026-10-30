import java.io.*;
import java.util.*;

/**
 * BGcdCompression
 */
public class BGcdCompression {


    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while(t-- > 0) {
            int n = fr.nextInt();
            int[] A = new int[2 * n];
            int size = 2 * n;

            List<Integer> odds = new ArrayList<>();
            List<Integer> evens = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                A[i] = fr.nextInt();
                if (A[i] % 2 != 0) {
                    odds.add(i + 1);
                } else {
                    evens.add(i + 1);
                }
            }

            int count = 0;

            for (int i = 0; i + 1 < odds.size() && count < n - 1; i += 2) {
                out.append(odds.get(i)).append(" ").append(odds.get(i + 1)).append("\n");
                count++;
            }

            for (int i = 0; i + 1 < evens.size() && count < n - 1; i += 2) {
                out.append(evens.get(i)).append(" ").append(evens.get(i + 1)).append("\n");
                count++;
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