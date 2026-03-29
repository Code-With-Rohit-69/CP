import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashSet<Integer> one = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int operation = sc.nextInt();
            int height = sc.nextInt();

            if(operation == 1) {
                one.add(height);
            } else {
                for(int h : one) {
                    if(h <= height) {
                        one.remove(h);
                    }
                }
            }

            System.out.println(one.size());

        }

        sc.close();
    }
}
