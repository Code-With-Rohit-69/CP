import java.util.Scanner;

public class A_Olesya_and_Rodion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        if (t == 0 || (t == 10 && n == 1)) {
            System.out.println(-1);
            sc.close();
            return;
        }

        StringBuilder ans = new StringBuilder();
        ans.append(t);

        if(t == 10) {
            ans.append("0".repeat(n - 2));
        } else {
            ans.append("0".repeat(n - 1));
        }

        System.out.println(ans.toString());

        sc.close();
    }
}