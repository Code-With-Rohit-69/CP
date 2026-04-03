import java.util.Scanner;

public class A_Black_Square {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int a4 = sc.nextInt();

        String s = sc.next();

        long calories = 0;

        for (char ch : s.toCharArray()) {
            if(ch == '1') calories += a1;
            if(ch == '2') calories += a2;
            if(ch == '3') calories += a3;
            if(ch == '4') calories += a4;
        }

        System.out.println(calories);

        sc.close();

    }
}