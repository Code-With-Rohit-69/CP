import java.util.Scanner;

public class A_AI_Project_Development {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            int time = (int) Math.ceil((double) n / (x + y));

            int newTime = 0;

            if(x * z >= n) {
                newTime = (n + x - 1) / x;
            } else {
                int lines = n - (x * z);
    
                y *= 10;
    
                newTime = z + (lines + x + y - 1) / (x + y);
            }
            
            
            System.out.println(Math.min(newTime, time));

        }

        sc.close();
    }
}
