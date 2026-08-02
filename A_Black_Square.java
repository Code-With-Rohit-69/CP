import java.util.Scanner;

public class A_Black_Square {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int a4 = sc.nextInt();

        String s = sc.next();

        long c = 0;

        for (char ch : s.toCharArray()) {
            if(ch == '1') c += a1;
            if(ch == '2') c += a2;
            if(ch == '3') c += a3;
            if(ch == '4') c += a4;
        }

        System.out.println(c);

        sc.close();

    }
}