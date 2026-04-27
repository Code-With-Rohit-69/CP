import java.util.Scanner;

public class B_Not_Quite_Latin_Square {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            
            int n = 3;

            while (n-- > 0) {
                String s = sc.next();

                if(s.indexOf('?') != -1) {
                    int[] freq = new int[3];

                    for (char c : s.toCharArray()) {
                        if (c != '?') {
                            freq[c - 'A']++;
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        if (freq[i] == 0) {
                            System.out.println((char) (i + 'A'));
                            break;
                        }
                    }

                }

            }

        }

        sc.close();
    }
}