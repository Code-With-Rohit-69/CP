import java.util.Scanner;

public class B_Following_Directions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int x = 0, y = 0;

            boolean reachedOrigin = false;

            for(char ch : s.toCharArray()) {
                if(ch == 'L') {
                    x--;
                } else if(ch == 'R') {
                    x++;
                } else if(ch == 'U') {
                    y++;
                } else if(ch == 'D') {
                    y--;
                }

                if(x == 1 && y == 1) {
                    reachedOrigin = true;
                    break;
                }

            }

            if (reachedOrigin) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}