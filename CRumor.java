import java.io.*;
import java.util.*;

/**
 * CRumor
 */
public class CRumor {

    public static long dfs(int node, long[] cost, boolean[] vis, ArrayList<Integer>[] graph) {
        vis[node] = true;
        long min = cost[node];
        
        for(int neigh : graph[node]) {
            if(!vis[neigh]) {
                min = Math.min(min, dfs(neigh, cost, vis, graph));
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt(), m = fr.nextInt();
        long[] cost = new long[n];

        for(int i = 0; i < n; i++) {
            cost[i] = fr.nextLong();
        }

        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        while(m-- > 0) {
            int u = fr.nextInt() - 1, v = fr.nextInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] vis = new boolean[n];
        long ans = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                long min = dfs(i, cost, vis, graph);
                ans += min;
            }
        }

        System.out.println(ans);
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