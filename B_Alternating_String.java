import java.util.Scanner;

public class B_Alternating_String {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int count = 0;
            int n = s.length();

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                }
            }

            System.out.println(count <= 2 ? "YES" : "NO");

        }

        sc.close();
    }
}