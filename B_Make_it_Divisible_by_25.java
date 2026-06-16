import java.util.Scanner;

public class B_Make_it_Divisible_by_25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int n = s.length() - 1;

            int zero = -1;
            int five = -1;

            int count = 0;

            for (int i = n; i >= 0; i--) {
                char ch = s.charAt(i);

                if (ch == '0') {
                    if (zero != -1) {
                        count = (zero - i - 1) + (n - zero);
                        break;
                    }

                    zero = i;
                } else if (ch == '5') {
                    if (zero != -1) {
                        count = (zero - i - 1) + (n - zero);
                        break;
                    }

                    five = i;
                } else if(ch == '2') {
                    if (five != -1) {
                        count = (five - i - 1) + (n - five);
                        break;
                    }
                } else if(ch == '7') {
                    if (five != -1) {
                        count = (five - i - 1) + (n - five);
                        break;
                    }
                }

            }

            System.out.println(count);

        }

        sc.close();
    }
}

// 25, 00, 75, 50