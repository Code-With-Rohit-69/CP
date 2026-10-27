import java.io.*;
import java.util.*;

/**
 * CEdgeAddeleting
 */
public class CEdgeAddeleting {

    public static void dfs(int v, int parent, int height, int[] dis, ArrayList<ArrayList<Integer>> graph) {
        dis[v] = height;

        if (v == 1) {
            return;
        }

        for (int u : graph.get(v)) {
            if (u != parent) {
                dfs(u, v, height + 1, dis, graph);
            }
        }
    }

    public static void bfs(int start, int[] dis, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dis[start] = 0;

        while (!q.isEmpty()) {
            int v = q.poll();

            if (v == 1) {
                continue;
            }

            for (int u : graph.get(v)) {
                if (dis[u] == -1) {
                    dis[u] = dis[v] + 1;
                    q.offer(u);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt(), m = fr.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++)
                graph.add(new ArrayList<>());

            for (int i = 0; i < n - 1; i++) {
                int u = fr.nextInt(), v = fr.nextInt();

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int[] dis = new int[n + 1];
            Arrays.fill(dis, -1);

            // dfs(n, n, 0, dis, graph);
            bfs(n, dis, graph);

            int ans = dis[1];

            for (int i = 0; i < m; i++) {
                int x = fr.nextInt();

                if (dis[x] != -1) {
                    ans = Math.max(ans, dis[x] + 1);
                }
            }

            out.append(ans + "\n");
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