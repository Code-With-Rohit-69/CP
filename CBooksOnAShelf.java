import java.io.*;
import java.util.*;

/**
 * CBooksOnAShelf
 */
public class CBooksOnAShelf {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while(t-- > 0) {
            int n = fr.nextInt();
            int[] A = new int[n];

            for(int i = 0; i < n; i++) A[i] = fr.nextInt();

            Arrays.sort(A);

            int[] res = new int[n];
            res[0] = A[0];
            int l = 1, r = n - 1;

            for(int i = 1; i < n; i++) {
                if(A[i] == A[i - 1]){
                    res[r--] = A[i];
                } else {
                    res[l++] = A[i];
                }
            }

            int left = 0;
            int max = 0;

            for(int i = 0; i < n; i++) {
                if(res[i] > max) {
                    max = res[i];
                    left = i + 1;
                }
            }

            int right = 0;

            if(left != n) {
                max = 0;

                for(int i = n - 1; i >= left; i--) {
                    if(res[i] > max) {
                        max = res[i];
                        right++;
                    }
                }
            }

            int count = left + right;

            out.append(count).append("\n");

            for(int x : res) out.append(x).append(" ");
            out.append("\n");
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