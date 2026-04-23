import java.util.*;

public class B_Normal_Problem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            int n = s.length();

            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == 'q') {
                    sb.append('p');
                } else if(s.charAt(i) == 'p') {
                    sb.append('q');
                } else {
                    sb.append(s.charAt(i));
                }
            }

            System.out.println(sb);
        }

        sc.close();
    }
}