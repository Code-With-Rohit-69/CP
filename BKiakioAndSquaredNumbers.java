import java.io.*;
import java.util.*;

/**
 * BKiakioAndSquaredNumbers
 */
public class BKiakioAndSquaredNumbers {

    public static int[] helper(int num) {
        int step = 0;

        while(num != 1 && num != 4) {
            int temp = num;
            int sum = 0;

            while(temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }

            num = sum;
            step++;
        }

        return new int[] {num, step};
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while(t-- > 0) {
            int n = fr.nextInt();
            HashMap<String, Integer> map = new HashMap<>();

            for(int i = 0; i < n; i++) {
                int x = fr.nextInt();

                int[] res = helper(x);
                String key;
                int value = res[1];

                if(res[0] == 1) {
                    key = "1";
                } else {
                    int m = res[1] % 8;
                    key = "4_" + m;
                }

                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int ans = 0;

            for(int value : map.values()) {
                ans += (value * (value - 1)) / 2;
            }

            out.append(ans).append("\n");   
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