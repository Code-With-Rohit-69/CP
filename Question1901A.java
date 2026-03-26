import java.util.*;

public class Question1901A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n, x;
            n = sc.nextInt();
            x = sc.nextInt();

            int minGas = (int) (-1e9);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);

            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }

            list.add(x);

            for (int i = 1; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    minGas = Math.max(minGas, 2 * (list.get(i) - list.get(i - 1)));
                } else {
                    minGas = Math.max(minGas, list.get(i) - list.get(i - 1));
                }
            }

            System.out.println(minGas);
        }

        sc.close();
    }
}