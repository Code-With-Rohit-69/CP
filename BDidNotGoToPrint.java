import java.io.*;
import java.util.*;

/**
 * BDidNotGoToPrint
 */
public class BDidNotGoToPrint {

    public static List<Integer> solve(String s, int n) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        boolean[] vis = new boolean[n + 1];

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '1') {
                stack.push(i);
            } else if(ch == '2') {
                if(stack.size() > 0) {
                    vis[stack.peek()] = true;
                    stack.pop();
                } else {
                    vis[i] = true;
                }
            } else {
                vis[i] = true;
            }
        }

        for(int i = 0; i < n; i++) {
            if(!vis[i]) list.add(i);
        }

        return list;
    }

    /*
    
        n = 6
        s = "112332"

        list = [0, 5]

    */

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while(t-- > 0) {
            int n = fr.nextInt();
            String s = fr.next();

            List<Integer> list = solve(s, n);

            out.append(list.size() + "\n");

            for(int x : list) {
                out.append((x + 1) + " ");
            }

            out.append("\n");
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