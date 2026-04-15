import java.util.Scanner;

public class A_Ilya_and_Bank_Account {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        if (Character.isDigit(s.charAt(0))) {
            System.out.println(s);
            sc.close();
            return;
        }

        int greaterIndex = -1;

        if(s.charAt(s.length() - 1) > s.charAt(s.length() - 2)) {
            greaterIndex = s.length() - 1;
        } else {
            greaterIndex = s.length() - 2;
        }

        String ans = s.substring(0, greaterIndex) + s.substring(greaterIndex + 1);

        System.out.println(ans.equals("-0") ? "0" : ans);

        sc.close();
    }
}