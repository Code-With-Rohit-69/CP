import java.io.*;
import java.util.*;

/**
 * DSubstring
 */
public class DSubstring {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt(), m = fr.nextInt();

        String s = fr.next();

        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            int u = fr.nextInt() - 1, v = fr.nextInt() - 1;
            graph[u].add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[][] dp = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                dp[i][s.charAt(i) - 'a'] += 1;
            }
        }

        int max = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            n--;

            for (int j = 0; j < 26; j++)
                max = Math.max(max, dp[node][j]);

            for (int neigh : graph[node]) {

                for (int j = 0; j < 26; j++) {
                    dp[neigh][j] = Math.max(dp[neigh][j], dp[node][j] + (s.charAt(neigh) - 'a' == j ? 1 : 0));
                }

                inDegree[neigh]--;

                if (inDegree[neigh] == 0) {
                    q.add(neigh);
                }
            }

        }

        System.out.println(n == 0 ? max : -1);

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