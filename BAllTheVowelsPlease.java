import java.io.*;
import java.util.*;

/**
 * BAllTheVowelsPlease
 */
public class BAllTheVowelsPlease {

    public static int[] seive(int k) {
        boolean[] prime = new boolean[k + 1];

        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for(int i = 2; i * i <= k; i++) {
            if(prime[i]) {
                for(int j = i; j <= k; j++) {
                    if(i * j == k && i >= 5 && j >= 5) return new int[] {i, j};
                }
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        
        int k = fr.nextInt();

        int[] constraints = seive(k);

        if(constraints[0] == -1) {
            System.out.println("-1");
            return;
        }

        int m = constraints[0], n = constraints[1];

        char[][] chars = new char[m][n];

        StringBuilder out = new StringBuilder();

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = vowels[(i + j) % 5];
            }
        }

        for(char[] chs : chars) {
            for(char ch : chs) {
                out.append(ch);
            }
        }

        System.out.println(out);
    }
}



/*

    0 1 2 3 4
0   a e i o u
1   e a        
2   i   a      
3   o     a    
4   u       a 

*/

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