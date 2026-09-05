import java.io.*;
import java.util.*;

/**
 * B_Equivalent_Strings
 */
public class B_Equivalent_Strings {

    // public static boolean helper(String s, String t) {
    //     if (s.equals(t))
    //         return true;

    //     int n = s.length();

    //     if (n % 2 != 0)
    //         return false;

    //     String a1 = s.substring(0, n / 2);
    //     String a2 = s.substring(n / 2);

    //     String b1 = t.substring(0, n / 2);
    //     String b2 = t.substring(n / 2);

    //     boolean option1 = helper(a1, b1) && helper(a2, b2);
    //     boolean option2 = helper(a1, b2) && helper(a2, b1);

    //     return option1 || option2;

    // }

    public static String helper(String s) {
        int n = s.length();

        if ((n & 1) == 1) {
            return s;
        }

        String firstHalf = helper(s.substring(0, n / 2));
        String secondHalf = helper(s.substring(n / 2));

        if (firstHalf.compareTo(secondHalf) < 0) {
            return firstHalf + secondHalf;
        } else {
            return secondHalf + firstHalf;
        }

    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        String s = fr.next();
        String t = fr.next();

        // boolean res = helper(s, t);
        // System.out.println(res ? "YES" : "NO");

        String newS = helper(s);
        String newT = helper(t);

        // System.out.println(newS + " " + newT);
        System.out.println(newS.equals(newT) ? "YES" : "NO");

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