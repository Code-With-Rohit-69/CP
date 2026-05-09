import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C_Dijkstra {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }

        long[] distance = new long[n + 1];

        Arrays.fill(distance, Long.MAX_VALUE);

        distance[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis));

        pq.add(new Pair(1, 0));

        boolean[] vis = new boolean[n + 1];
        int[] path = new int[n + 1];

        for (int i = 0; i < path.length; i++) {
            path[i] = i;
        }

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            int node = curr.node;
            long dis = curr.dis;

            if (!vis[node]) {
                vis[node] = true;

                for (Edge edge : graph[node]) {
                    int u = edge.src;
                    int v = edge.des;
                    int w = edge.wt;

                    if (distance[u] + w < distance[v]) {
                        distance[v] = distance[u] + w;
                        path[v] = u;
                        pq.add(new Pair(v, (long) distance[v]));
                    }
                }
            }
        }

        if(distance[n] == Long.MAX_VALUE) {
            System.out.println(-1);
            sc.close();
            return;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        int dest = n;

        while (path[dest] != dest) {
            ans.add(dest);
            dest = path[dest];
        }

        ans.add(1);

        for (int j = ans.size() - 1; j >= 0; j--) {
            System.out.print(ans.get(j) + " ");
        }

        sc.close();
    }
}

class Edge {
    int src, des, wt;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.des = d;
        this.wt = w;
    }
}

class Pair {
    int node;
    long dis;

    public Pair(int n, long d) {
        this.node = n;
        this.dis = d;
    }
}

/*
 * 2 4
 * 1 ------------- 2 ------------ 3
 * | | |
 * 1 | | 5 | 1
 * | | |
 * 4 5--------------|
 * | |
 * | |
 * ------------------------------
 * 3
 */