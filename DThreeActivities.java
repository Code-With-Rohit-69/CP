import java.io.*;
import java.util.*;

/**
 * DThreeActivities
 */
public class DThreeActivities {

    public static long solve(int[][] A, int[][] B, int[][] C, int n) {
        Arrays.sort(A, (a, b) -> Integer.compare(b[0], a[0]));
        Arrays.sort(B, (a, b) -> Integer.compare(b[0], a[0]));
        Arrays.sort(C, (a, b) -> Integer.compare(b[0], a[0]));

        long res = 0L;

        n = 3;

        for(int i = 0; i < n; i++) {
            int dayA = A[i][1];
            for(int j = 0; j < n; j++) {
                int dayB = B[j][1];

                for(int k = 0; k < n; k++) {
                    int dayC = C[k][1];

                    if(dayA != dayB && dayA != dayC && dayB != dayC) {
                        res = Math.max(res, (long) A[i][0] + B[j][0] + C[k][0]);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while(t-- > 0) {
            int n = fr.nextInt();
            int[][] A = new int[n][2], B = new int[n][2], C = new int[n][2];

            for(int i = 0; i < n; i++) {
                A[i][0] = fr.nextInt();
                A[i][1] = i;
            }

            for(int i = 0; i < n; i++) {
                B[i][0] = fr.nextInt();
                B[i][1] = i;
            }

            for(int i = 0; i < n; i++) {
                C[i][0] = fr.nextInt();
                C[i][1] = i;
            }

            long res = solve(A, B, C, n);

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