import java.util.Scanner;

public class C_Omsk_Programmers {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();

            long ans = Math.abs(a - b);
            long ops = 0;

            while (a != b) {
                if (a > b) {
                    a /= x;
                } else {
                    b /= x;
                }

                ops++;

                ans = Math.min(ans, ops + Math.abs(a - b));
            }

            System.out.println(ans);

        }

        sc.close();
    }
}


/*

    a = 17, b = 3, c = 3;

    min = 17 - 3 = 14;
    
    count = 0

    ------ while loop -------

    (1)

    min = (min = 17, 1 + 2) = 3
    min = (min = 3, 1 + 16) = 3

    a = 17 / 3 = 5;
    b = 3 / 3 = 1;

    count = 1

    (2)

    min = (min = 3, 1 + 0) = 1
    min = (min = 1, 1 + 5) = 1


*/