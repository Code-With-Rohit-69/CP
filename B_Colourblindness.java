import java.util.Scanner;

public class B_Colourblindness {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int col = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();

            boolean isSame = true;

            for (int i = 0; i < col; i++) {
                char c1 = s1.charAt(i), c2 = s2.charAt(i);
                if (c1 == c2)
                    continue;

                if ((c1 == 'G' || c1 == 'B') && (c2 == 'G' || c2 == 'B')) {
                    continue;
                }

                isSame = false;
                break;
            }

            if (isSame) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}