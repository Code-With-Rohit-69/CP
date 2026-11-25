import java.io.*;
import java.util.*;

/**
 * CEqualSums
 */
public class CEqualSums {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int k = fr.nextInt();
        HashMap<Long, int[]> map = new HashMap<>();

        for(int i = 0; i < k; i++) {
            int n = fr.nextInt();

            int[] A = new int[n];
            long sum = 0L;

            for(int j = 0; j < n; j++) {
                A[j] = fr.nextInt();
                sum += A[j];
            }

            for(int j = 0; j < n; j++) {
                long rem = sum - A[j];

                if(map.containsKey(rem) && map.get(rem)[0] != i) {
                    System.out.println("YES");
                    System.out.println((map.get(rem)[0] + 1) + " " + (map.get(rem)[1] + 1));
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }

                map.put(rem, new int[]{i, j});
            }

        }

        System.out.println("NO");

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