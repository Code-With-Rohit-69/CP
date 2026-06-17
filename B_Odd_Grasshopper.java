import java.util.Scanner;

public class B_Odd_Grasshopper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long x0 = sc.nextLong();
            long n = sc.nextLong();

            long rem = n % 4;

            long i = n - rem + 1;

            while(i <= n) {

                if ((x0 & 1) == 0) { // even
                    x0 -= i;
                } else { // odd
                    x0 += i;
                }

                i++;
            }

            System.out.println(x0);

        }

        sc.close();
    }    
}

/*

    
 x = 10, n = 10;

 i = 0;
 x = 10 -
 i = 1;
 x = 9
 i = 2;
 x = 11
 i = 3;
 x = 14

 i = 4;
 x = 10 -
 i = 5;
 x = 5
 i = 6
 x = 11
 i = 7
 x = 18

 i = 8
 x = 10 -
 i = 9
 x = 1
 i = 10
 x = 11
 i = 11
 x = 22

 i = 12
 x = 10 -


 Har i % 4 == 0 pe hame given x hi mill rha hain


*/