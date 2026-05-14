import java.util.Scanner;

public class A_Gennady_and_a_Card_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cardOnTable = sc.next();

        boolean res = false;

        for (int i = 0; i < 5; i++) {
            String card = sc.next();

            if (!res && cardOnTable.charAt(0) == card.charAt(0) || cardOnTable.charAt(1) == card.charAt(1)) {
                res = true;
            }

        }

        if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


        sc.close();
    }
}