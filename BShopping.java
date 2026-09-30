import java.io.*;
import java.util.*;

/**
 * BShopping
 */
public class BShopping {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int sum = 0;

        int n = fr.nextInt(); //  user
        int m = fr.nextInt(); // items
        int k = fr.nextInt(); //  total items

        int[] A = new int[k];

        for(int i = 0; i < k; i++) A[i] = fr.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int Aij = fr.nextInt();

                int position = -1;

                for(int pos = 0; pos < k; pos++) {
                    if(A[pos] == Aij) {
                        sum += pos + 1;
                        position = pos;
                        break;
                    }
                }

                for(int pos = position; pos >= 1; pos--) {
                    A[pos] = A[pos - 1];
                }

                A[0] = Aij;
            }
        }

        System.out.println(sum);

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