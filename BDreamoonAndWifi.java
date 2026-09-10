import java.io.*;
import java.util.*;

/**
 * BDreamoonAndWifi
 */
public class BDreamoonAndWifi {

    static int total = 0;
    static int second = 0;
    // static int[][] dp;

    public static void dfs(String s, int index, int sum, int first) {
        if (index >= s.length()) {
            if (sum == first)
                second++;
            total++;
            return;
        }

        // if(dp[index][sum] != -1) return dp[index][sum];

        char ch = s.charAt(index);

        if (ch != '?') {
            if (ch == '+') {
                dfs(s, index + 1, sum + 1, first);
            } else {
                dfs(s, index + 1, sum - 1, first);
            }
        } else {
            dfs(s, index + 1, sum + 1, first);
            dfs(s, index + 1, sum - 1, first);
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        String s = fr.next();
        String t = fr.next();

        int first = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '+')
                first++;
            else
                first--;
        }

        // dp = new int[t.length()][11];

        // for(int[] A : dp) Arrays.fill(A, -1);

        dfs(t, 0, 0, first);

        // System.out.println("total: " + total + " second: " + second);

        System.out.println((double) second / total);

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