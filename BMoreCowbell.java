import java.io.*;
import java.util.*;

/**
 * BMoreCowbell
 */
public class BMoreCowbell {

    public static boolean check(int[] arr, long sum, int k) {
        int n = arr.length;

        if (arr[0] > sum)
            return false;

        int i = 0;
        int boxes = 0;

        while(i < n) {
            if (boxes > k) {
                break;
            }

            if(i == n - 1) {
                boxes++;
                break;
            }

            if (arr[i] + arr[i + 1] <= sum) {
                i++;
            }

            i++;
            boxes++;
        }

        return boxes <= k;

    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt(), k = fr.nextInt();

        int[] arr = new int[n];
        long sum = 0L;

        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
            sum += arr[i];
        }

        long i = arr[n - 1], j = sum;
        long res = sum;

        while (i <= j) {
            long mid = i + (j - i) / 2;

            if (check(arr, mid, k)) {
                res = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }

        }

        System.out.println(res);

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
