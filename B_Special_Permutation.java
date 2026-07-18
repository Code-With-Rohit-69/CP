import java.io.*;
import java.util.*;

/**
 * B_Special_Permutation
 */

public class B_Special_Permutation {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            int a = fr.nextInt();
            int b = fr.nextInt();

            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            left.add(a);
            right.add(b);

            int i = n;

            while (i > a && left.size() < n / 2) {
                if (i != b) {
                    left.add(i);
                }

                i--;
            }

            if (left.size() < n / 2) {
                out.println(-1);
                continue;
            }

            i = 1;

            while (i < b && right.size() < n / 2) {
                if (i != a) {
                    right.add(i);
                }

                i++;
            }

            if (right.size() < n / 2) {
                out.println(-1);
                continue;
            }

            for (int x : left)
                out.print(x + " ");
            for (int x : right)
                out.print(x + " ");

            out.println();

        }

        out.flush();

    }
}

/*
 * 
 * 2 6 3 1 4 5
 * -1
 * 4 5 6 1 2 3
 * 2 3 1 4
 * -1
 * 1 2
 * 2 1
 * 
 * 
 * 1 6 5 3 2 4
 * 
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