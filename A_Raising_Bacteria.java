import java.util.Scanner;

public class A_Raising_Bacteria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int res = Integer.bitCount(x);
        System.out.println(res);

        sc.close();
    }
}