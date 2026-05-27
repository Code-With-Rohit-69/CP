import java.util.Scanner;

public class A_Chat_Server_s_Outgoing_Traffic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNext()) {
            return;
        }

        int len = 0;
        int peoples = 0;

        while (sc.hasNextLine()) {

            String s = sc.nextLine();
            int n = s.length();

            if (s.charAt(0) == '+') {
                peoples++;
            } else if (s.charAt(0) == '-') {
                peoples--;
            } else {
                int index = s.indexOf(':');
                len += (n - index - 1) * peoples    ;
            }

        }

        System.out.println(len);

        sc.close();
    }
}