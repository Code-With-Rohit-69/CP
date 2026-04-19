import java.util.Scanner;

public class B_Atilla_s_Favorite_Problem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            char ch = 'a';

            for(char c : s.toCharArray()) {
                if(ch < c) {
                    ch = c;
                }
            }

            System.out.println((int) ch - 'a' + 1);

        }

        sc.close();
    }
}