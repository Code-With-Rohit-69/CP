import java.util.HashMap;
import java.util.Scanner;

public class B_Lecture {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            String s = sc.next();
            String t = sc.next();
            
            if(t.length() < s.length()) {
                map.put(s, t);
            } else {
                map.put(s, s);
            }
        }

    
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.print(map.get(s) + " ");
        }

        sc.close();
    }
}