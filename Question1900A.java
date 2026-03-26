import java.util.*;

public class Question1900A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int count = 0;

            for (int i = 0; i < n; i++) {

                if (i + 2 < n && s.charAt(i) == '.' && s.charAt(i + 1) == '.' && s.charAt(i + 2) == '.') {
                    count = 2;
                    break;
                } else if(s.charAt(i) == '.') {
                    count++;
                }
            }

            System.out.println(count);

        }

        sc.close();
    }
}