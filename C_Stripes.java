import java.util.Scanner;

public class C_Stripes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String[] str = new String[8];

            for (int i = 0; i < 8; i++) {
                str[i] = sc.next();
            }

            char ch = '#';
            
            for (int i = 0; i < 8; i++) {
                boolean found = true;

                for (int j = 1; j < 8; j++) {
                    if (str[i].charAt(j) != str[i].charAt(j - 1)) {
                        found = false;
                        break;
                    }
                }
                
                if (found && str[i].charAt(0) == 'R') {
                    ch = str[i].charAt(0);
                }

            }

            if (ch == 'B' || ch == 'R') {
                System.out.println(ch);
                continue;
            }

            for (int j = 0; j < 8; j++) {
                boolean found = true;

                for (int i = 1; i < 8; i++) {
                    if (str[i].charAt(j) != str[i - 1].charAt(j)) {
                        found = false;
                        break;
                    }
                }
                
                if (found && str[0].charAt(j) == 'B') {
                    ch = str[0].charAt(j);
                }
            }   

            System.out.println(ch);

        }

        sc.close();
    }
}