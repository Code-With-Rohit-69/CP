import java.util.Scanner;

public class B_01_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int zero = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                }
            }
            int one = s.length() - zero;

            int min = Math.min(zero, one);

            
            if (min % 2 == 1) {
                System.out.println("DA");
            } else {
                System.out.println("NET");
            }

        }

        sc.close();
    }
}
