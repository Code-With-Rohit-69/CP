import java.util.Scanner;

public class A_Trippi_Troppi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine(); 

        while(t-- > 0) {
            String[] s = sc.nextLine().split(" ");
            String ans = "";

            for (String string : s) {
                ans = ans + string.charAt(0);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}