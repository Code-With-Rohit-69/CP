import java.util.Scanner;

public class B_Swap_and_Delete {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int n = s.length();

            if (n == 1) {
                System.out.println(1);
                continue;
            }

            int ones = 0, zeros = 0;

            for(char ch : s.toCharArray()) {
                if(ch == '0') zeros++;
                else ones++;
            }

            if (ones == zeros) {
                System.out.println(0);
                continue;
            }


            int i = 0;

            while (i < n) {
                char ch = s.charAt(i);

                if(ch == '0') {
                    if (ones == 0) {
                        break;
                    }

                    ones--;
                } else {
                    if (zeros == 0) {
                        break;
                    }

                    zeros--;
                }

                i++;
                
            }

            System.out.println(n - i);


        }

        sc.close();
    }
}