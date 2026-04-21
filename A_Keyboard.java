import java.util.Scanner;

public class A_Keyboard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "qwertyuiopasdfghjkl;zxcvbnm,./";

        char dir = sc.next().charAt(0);
        String word = sc.next();

        StringBuilder ans = new StringBuilder();

        if(dir == 'R') {
            for (int i = 0; i < word.length(); i++) {
                ans.append(s.charAt(s.indexOf(word.charAt(i)) - 1));
            }

        } else {
            for (int i = 0; i < word.length(); i++) {
                ans.append(s.charAt(s.indexOf(word.charAt(i)) + 1));
            }
        }

        System.out.println(ans);

        sc.close();
    }
}