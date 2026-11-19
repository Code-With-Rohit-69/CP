import java.io.*;
import java.util.*;

/**
 * ABearAndFriendshipCondition
 */
public class ABearAndFriendshipCondition {

    public static int[] dfs(int node, boolean[] vis, ArrayList<Integer>[] graph) {
        vis[node] = true;
        int countNode = 1, edge = graph[node].size();;

        for(int neigh : graph[node]) {
            if(!vis[neigh]) {
                int[] res = dfs(neigh, vis, graph);
                countNode += res[0];
                edge += res[1];
            }
        }

        return new int[] {countNode, edge};
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt(), m = fr.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        while(m-- > 0) {
            int u = fr.nextInt() - 1, v = fr.nextInt() - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                int[] res = dfs(i, vis, graph);
                int size = res[0];
                long edge = (long) size * (size - 1) / 2;
                
                if(edge != res[1] / 2) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");

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