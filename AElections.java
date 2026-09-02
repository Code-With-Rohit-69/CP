import java.io.*;
import java.util.*;

/**
 * AElections
 */
public class AElections {

    public static void main(String[] args) throws IOException{
        
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int m = fr.nextInt();

        int[][] arr = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = fr.nextInt();
            }
        }

        int[] freq = new int[n + 1];

        for(int i = 0; i < m; i++) {
            int index = -1;
            int elem = Integer.MIN_VALUE;

            for(int j = 0; j < n; j++) {
                if (arr[i][j] > elem) {
                    elem = arr[i][j];
                    index = j;
                }
            }

            freq[index + 1]++;
        }

        int index = -1;
        int elem = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++) {

            if (freq[i] > elem) {
                elem = freq[i];
                index = i;
            }
        }

        System.out.println(index);

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

