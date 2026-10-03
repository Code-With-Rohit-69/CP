import java.io.*;
import java.util.*;

/**
 * StaticRangeSumQueries
 */
public class StaticRangeSumQueries {

    static long[] tree;

    public static void build(int index, int i, int j, long[] A) {
        if(i == j) {
            tree[index] = A[i];
            return;
        }

        int mid = (i + j) >> 1;

        build(2 * index + 1, i, mid, A);
        build(2 * index + 2, mid + 1, j, A);

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public static long query(int index, int i, int j, int l, int r) {
        if(l > j || r < i) return 0;

        if(i >= l && j <= r) return tree[index];

        int mid = (i + j) >> 1;

        long L = query(2 * index + 1, i, mid, l, r);
        long R = query(2 * index + 2, mid + 1, j, l, r);

        return L + R;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int n = fr.nextInt();
        int q = fr.nextInt();

        long[] A = new long[n];

        for(int i = 0; i < n; i++) A[i] = fr.nextLong();

        tree = new long[4 * n];
        build(0, 0, n - 1, A);

        while(q-- > 0) {
            int l = fr.nextInt() - 1;
            int r = fr.nextInt() - 1;

            long res = query(0, 0, n - 1, l, r);

            out.append(res + "\n");
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