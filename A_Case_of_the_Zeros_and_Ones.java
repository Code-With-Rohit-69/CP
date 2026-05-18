import java.util.*;

public class A_Case_of_the_Zeros_and_Ones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() != ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }

        }

        System.out.println(stack.size());

        sc.close();
    }
}