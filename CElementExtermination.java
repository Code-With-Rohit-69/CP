
import java.io.*;
import java.util.*;

public class CElementExtermination {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();

        int t = fr.nextInt();

        while(t-- > 0) {
            int n = fr.nextInt();
            int[] A = new int[n];

            for(int i = 0; i < n; i++) {
                A[i] = fr.nextInt();
            }

            if(A[0] < A[n - 1]) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
        }

        System.out.print(out);
    }
}

class FastReader {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;

    private int read() throws IOException {
        if(ptr >= len) {
            len = in.read(buffer);
            ptr = 0;
            if(len <= 0) return -1;
        }
        return buffer[ptr++];
    }

    int nextInt() throws IOException {
        int c;
        while((c = read()) <= ' ') {
            if(c == -1) return -1;
        }

        int sign = 1;
        if(c == '-') {
            sign = -1;
            c = read();
        }

        int num = 0;
        while(c > ' ') {
            num = num * 10 + (c - '0');
            c = read();
        }

        return num * sign;
    }
}
