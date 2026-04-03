import java.util.Scanner;

public class A_Short_Substrings {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < s.length() - 2; i += 2) {
                sb.append(s.charAt(i));
            }

            sb.append(s.charAt(s.length() - 2)).append(s.charAt(s.length() - 1));
            System.out.println(sb.toString());

        }

        sc.close();
    }
}
