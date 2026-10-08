import java.io.*;
import java.util.*;

/**
 * BBashSBigDay
 */
public class BBashSBigDay {

    static List<Integer> list;
    static int MAX = 100001;

    public static void sieve() {
        boolean[] prime = new boolean[MAX];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 2; i < MAX; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();

        int[] count = new int[100001];

        for (int i = 0; i < n; i++) {
            int val = fr.nextInt();

            for (int d = 2; d * d <= val; d++) {
                if (val % d == 0) {
                    count[d]++;
                    while (val % d == 0) val /= d; // duplicates hatao
                }
            }
            if (val > 1) {
                count[val]++;
            }
        }x

        int max = 1;
        for (int i = 2; i <= 100000; i++) {
            max = Math.max(max, count[i]);
        }

        System.out.println(max);

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