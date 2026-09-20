import java.io.*;
import java.util.*;

/**
 * CPermuteDigits
 */
public class CPermuteDigits {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        String s = fr.next();
        String t = fr.next();

        StringBuilder out = new StringBuilder();

        int[] freq = new int[10];

        for (char ch : s.toCharArray()) {
            freq[ch - '0']++;
        }

        if (s.length() > t.length()) {
            System.out.println(s);
            return;
        }

        for (int i = 0; i < s.length() && t.length() <= s.length(); i++) {
            int index = t.charAt(i) - '0';

            while (index >= 0 && freq[index] == 0) {
                index--;
            }

            if (index >= 0) {
                out.append(index);
                freq[index]--;

                if (index < (t.charAt(i) - '0')) {
                    break;
                }
            } else {
                while (out.length() > 0) {
                    int last = out.charAt(out.length() - 1) - '0';
                    out.deleteCharAt(out.length() - 1);
                    freq[last]++;

                    int smallerDigit = -1;
                    for (int j = last - 1; j >= 0; j--) {
                        if (freq[j] > 0) {
                            smallerDigit = j;
                            break;
                        }
                    }

                    if (smallerDigit != -1) {
                        out.append(smallerDigit);
                        freq[smallerDigit]--;
                        break;
                    }
                }
                break;
            }

        }

        for (int i = 9; i >= 0; i--) {
            while (freq[i] > 0) {
                out.append(i);
                freq[i]--;
            }
        }

        System.out.println(out.toString());

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