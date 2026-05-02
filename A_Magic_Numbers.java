import java.util.Scanner;

public class A_Magic_Numbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int n = s.length();
        int i = 0;

        for (; i < n;) {
            // 144

            if (i + 3 <= n) {
                String substr = s.substring(i, i + 3);
                if (substr.equals("144")) {
                    i += 3;
                    continue;
                }
            }

            // 14

            if (i + 2 <= n) {
                String substr = s.substring(i, i + 2);
                if (substr.equals("14")) {
                    i += 2;
                    continue;
                }
            }

            // 1

            if (i + 1 <= n) {
                String substr = s.substring(i, i + 1);

                if (substr.equals("1")) {
                    i += 1;
                    continue;
                }
            }

            break;

        }

        if (i >= n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}