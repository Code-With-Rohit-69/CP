import java.io.*;
import java.util.*;

/**
 * DAnimals
 */
public class DAnimals {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        int n = fr.nextInt();
        int k = fr.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = fr.nextInt();
        }

        long[] cost = new long[n];

        for(int i = 0; i < n; i++) {
            cost[i] = (long) A[i] * (n - i);
        }

        Arrays.sort(cost);

        int i = 0;

        while(i < n && k >= cost[i]) {
            k -= cost[i];
            i++;
        }

        pw.println(i);
        pw.close();

    }
}

class FastReader {
    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;

    public FastReader() throws FileNotFoundException {
        in = new FileInputStream("input.txt");
    }

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