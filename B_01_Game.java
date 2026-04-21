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
            if (zero == one) {
                if (zero % 2 == 0) {
                    System.out.println("NET");
                } else {
                    System.out.println("DA");
                }
            } else {
                System.out.println("NET");
            }
        }

        sc.close();
    }
}
