import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class B_Array_merging {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            HashMap<Integer, Integer> mapA = new HashMap<>();
            HashMap<Integer, Integer> mapB = new HashMap<>();

            int[] A = new int[n];
            int[] B = new int[n];

            for (int i = 0; i < n; i++) {
                A[i] = fr.nextInt();
            }

            for (int i = 0; i < n; i++) {
                B[i] = fr.nextInt();
            }

            int count = 1;

            for (int i = 1; i < n; i++) {
                if (A[i] != A[i - 1]) {
                    int get = mapA.getOrDefault(A[i - 1], 0);
                    int maxVal = Math.max(get, count);
                    mapA.put(A[i - 1], maxVal);
                    count = 1;
                } else {
                    count++;
                }
            }

            int get = mapA.getOrDefault(A[n - 1], 0);
            int maxVal = Math.max(get, count);
            mapA.put(A[n - 1], maxVal);

            count = 1;

            for (int i = 1; i < n; i++) {
                if (B[i] != B[i - 1]) {
                    get = mapB.getOrDefault(B[i - 1], 0);
                    maxVal = Math.max(get, count);
                    mapB.put(B[i - 1], maxVal);
                    count = 1;
                } else {
                    count++;
                }
            }

            get = mapB.getOrDefault(B[n - 1], 0);
            maxVal = Math.max(get, count);
            mapB.put(B[n - 1], maxVal);

            int max = 0;

            for (int key : mapA.keySet()) {
                max = Math.max(max, mapA.get(key) + mapB.getOrDefault(key, 0));
            }

            for (int key : mapB.keySet()) {
                max = Math.max(max, mapB.get(key) + mapA.getOrDefault(key, 0));
            }

            out.println(max);

        }

        out.flush();
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