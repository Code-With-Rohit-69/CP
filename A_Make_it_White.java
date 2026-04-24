import java.util.Scanner;

public class A_Make_it_White {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int firstPosition = s.indexOf('B');
            int lastPosition = s.lastIndexOf('B');

            System.out.println(lastPosition - firstPosition + 1);

        }

        sc.close();
    }
}