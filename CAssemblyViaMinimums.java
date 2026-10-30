import java.io.*;
import java.util.*;

/**
 * CAssemblyViaMinimums
 */
public class CAssemblyViaMinimums {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while(t-- > 0) {
            int n = fr.nextInt();
            int N = (n * (n - 1)) / 2;
            int[] A = new int[N];

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < N; i++) {
                A[i] = fr.nextInt();
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            }

            Arrays.sort(A);
            int size = 0;

            // for(int i = 0; i < N; i++) {
            //     int x = A[i];
            //     if(!map.containsKey(x)) continue;

            //     out.append(x + " ");
                
            //     int times = map.get(x) / n;
            //     for(int j = 0; j < times; j++) out.append(x + " ");

            //     size += times + 1;

            //     map.remove(x);
            // }

            for(int i = 0; i < N; ) {
                int x = A[i];
                
                out.append(x + " ");
                size++;

                int count = map.get(x);
                i += count;                 
            }

            while(size < n) {
                out.append(A[N - 1] + " ");
                size++;
            }

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