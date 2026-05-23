import java.util.Scanner;

public class B_Odd_Grasshopper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long x0 = sc.nextLong();
            long n = sc.nextLong();

            if(n % 4 == 0) {
                System.out.println(0);
            } else if(n % 4 == 3) {
                System.out.println(n + 1);
            } else if (n % 4 == 2) {
                System.out.println(1);
            } else if (n % 4 == 1) {
                System.out.println(-n);
            }

        }

        sc.close();
    }    
}

/*

    





*/