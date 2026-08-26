import java.io.*;
import java.util.*;

public class AMagicSpheres {
    
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
        int x = fr.nextInt(), y = fr.nextInt(), z = fr.nextInt();

        if (a >= x && b >= y && c >= z) {
            System.out.println("Yes");
            return;
        }

        int extra = 0;

        if (a > x && a - x > 1) {
            int diff = a - x;
            
            extra += (diff / 2);
        }

        if (b > y && b - y > 1) {
            int diff = b - y;
            
            extra += (diff / 2);
        }

        if (c > z && c - z > 1) {
            int diff = c - z;
            
            extra += (diff / 2);
        }

        int needed = 0;

        if (a < x) {
            needed = x - a;
        }

        if (b < y) {
            needed += y - b;
        }

        if (c < z) {
            needed += z - c;
        }

        // System.out.println(extra + " " + needed);

        System.out.println(extra >= needed ? "Yes" : "No");

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
