import java.util.Scanner;

public class A_Square_String {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            if ((n & 1) != 0) {
                System.out.println("NO");
                continue;
            }

            boolean found = true;

            int half = n / 2;

            for (int i = 0; i < half; i++) {
                if (s.charAt(i) != s.charAt(i + half)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}