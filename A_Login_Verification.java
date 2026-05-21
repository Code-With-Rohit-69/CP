import java.util.Scanner;

public class A_Login_Verification {

    static char normalize(char ch) {

        ch = Character.toLowerCase(ch);

        if (ch == 'o' || ch == '0') {
            return 'o';
        }

        if (ch == '1' || ch == 'l' || ch == 'i') {
            return '1';
        }

        return ch;
    }

    static boolean similar(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {

            char ch1 = normalize(a.charAt(i));
            char ch2 = normalize(b.charAt(i));

            if (ch1 != ch2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = sc.nextInt();

        boolean possible = true;

        for (int i = 0; i < n; i++) {

            String existing = sc.next();

            if (similar(s, existing)) {
                possible = false;
            }
        }

        System.out.println(possible ? "Yes" : "No");

        sc.close();
    }
}