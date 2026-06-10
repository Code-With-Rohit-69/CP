import java.util.Scanner;

public class D_Deletive_Editing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            String s = sc.next();
            String t = sc.next();

            int n = s.length() - 1;
            int m = t.length() - 1;

            int[] freq = new int[26];

            while (n >= 0 && m >= 0) {
                if(s.charAt(n) == t.charAt(m)) {
                    if (freq[s.charAt(n) - 'A'] > 0) {
                        break;
                    }

                    freq[s.charAt(n) - 'A'] = Math.max(0, freq[s.charAt(n) - 'A']--);

                    n--;
                    m--;
                } else {
                    freq[s.charAt(n) - 'A'] += 1;
                    n--;
                }
            }

            // for (int i = 0; i < freq.length; i++) {
            //     System.out.print(((char) (i + 'A')) + " -> " + freq[i] + ", ");
            // }

            // System.out.println();

            if (m == -1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}