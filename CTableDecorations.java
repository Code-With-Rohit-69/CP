import java.io.*;
import java.util.*;

/**
 * CTableDecorations
 */

public class CTableDecorations {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int[] arr = new int[3];

        for(int i = 0; i < 3; i++) {
            arr[i] = fr.nextInt();
        }

        Arrays.sort(arr);

        int count = 0;

        for(int x : arr) {
            if(x == 0) count++;
        }

        if(count == 3 || count == 2) {
            System.out.println(0);
        } else if(count == 1) {
            System.out.println(Math.min((arr[1] + arr[2]) / 3, arr[1]));
        } else {
            long a = arr[0];
            long b = arr[1];
            long c = arr[2];

            long option1 = (a + b + c) / 3;

            long option2 = 2 * (a + b);

            System.out.println(Math.min(option1, option2));
        }


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