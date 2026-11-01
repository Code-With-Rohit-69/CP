import java.io.*;
import java.util.*;

/**
 * BSubstringRemoval
 */

/*

    n = 3
    "aaa"

*/

public class BSubstringRemoval {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int MOD = 998244353;

        int n = fr.nextInt();
        String s = fr.next();

        if(n == 2) {
            System.out.println(3);
            return;
        }

        HashSet<Character> set = new HashSet<>();

        for(char ch : s.toCharArray()) {
            set.add(ch);
        }

        if(set.size() == 1) {
            long ans = ((long) n * (n + 1) / 2) % MOD;
            System.out.println(ans);
            return;
        }

        long c1 = 0;

        while(c1 < n && s.charAt((int) c1) == s.charAt(0)) {
            c1++;
        }

        long c2 = 0;

        while(c2 < n && s.charAt(n - 1 - (int) c2) == s.charAt(n - 1)) {
            c2++;
        }

        long ans = 0L;

        if(s.charAt(0) == s.charAt(n - 1)) {
            ans = ((c1 + 1) * (c2 + 1)) % MOD;
        } else {
            ans = (c1 + c2 + 1) % MOD;
        }

        System.out.println(ans);
        return;

    }
}

// aabbbccccaa

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