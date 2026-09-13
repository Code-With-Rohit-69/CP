import java.io.*;

/**
 * CReplacement
 */
public class CReplacement {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt(), m = fr.nextInt();
        String s = fr.next();

        char[] ch = s.toCharArray();
        int dots = 0;
        int blocks = 0;
        int curr = 0;

        StringBuilder out = new StringBuilder();

        for (char c : ch) {
            if (c == '.') {
                dots++;
                curr++;
            } else {
                if (curr > 0) {
                    blocks++;
                    curr = 0;
                }
            }
        }

        if (curr > 0) {
            blocks++;
            curr = 0;
        }

        // System.out.println("Total Dots: " + dots + " and total blocks: " + blocks);

        for (int i = 0; i < m; i++) {
            int xi = fr.nextInt() - 1;
            char ci = fr.next().charAt(0);

            char original = ch[xi];

            if (original == ci) {
                out.append(dots - blocks).append("\n");
                continue;
            }

            ch[xi] = ci;

            // if (original != '.' && ci == '.') {
            // dots++;

            // if ((xi - 1 < 0 && ch[xi + 1] != '.') || (xi + 1 >= n && ch[xi - 1] != '.')
            // || (ch[xi - 1] != '.' && ch[xi + 1] != '.')) {
            // blocks++;
            // }

            // } else if (original == '.' && ci != '.') {
            // dots--;

            // if ((xi - 1 < 0 && ch[xi + 1] != '.') || (xi + 1 >= n && ch[xi - 1] != '.')
            // || (ch[xi + 1] != '.' && ch[xi - 1] != '.')) {
            // blocks--;
            // }

            // }

            boolean leftIsDot = (xi > 0) && (ch[xi - 1] == '.');
            boolean rightIsDot = (xi < n - 1) && (ch[xi + 1] == '.');

            if (original != '.' && ci == '.') {
                dots++;
                if (!leftIsDot && !rightIsDot) {
                    blocks++;
                } else if (leftIsDot && rightIsDot) {
                    blocks--;
                }

            } else if (original == '.' && ci != '.') {
                dots--;
                if (!leftIsDot && !rightIsDot) {
                    blocks--;
                } else if (leftIsDot && rightIsDot) {
                    blocks++;
                }
            }

            out.append(dots - blocks + "\n");

            // System.out.println(new String(ch));
            // System.out.println("Total Dots: " + dots + " and total blocks: " + blocks);

        }

        System.out.println(out);

    }
}

/*
 * 
 * "..dn.."
 * "asn.sd.."
 * 
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
