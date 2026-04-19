import java.util.Scanner;

public class C_Word_on_the_Paper {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int col = -1;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                String s = sc.next();

                if (col == -1) {
                    for (int j = 0; j < 8; j++) {
                        if(s.charAt(j) != '.') {
                            col = j;
                            sb.append(s.charAt(j));
                            break;
                        }
                    }
                } else {
                    if (s.charAt(col) != '.') {
                        sb.append(s.charAt(col));
                    }
                }
            }

            System.out.println(sb.toString());

        }

        sc.close();
    }
}