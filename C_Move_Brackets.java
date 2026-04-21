import java.util.Scanner;
import java.util.Stack;

public class C_Move_Brackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }

            System.out.println(stack.size() / 2);

        }

        sc.close();
    }
}