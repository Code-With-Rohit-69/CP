import java.util.Scanner;

public class A_Night_at_the_Museum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int rotations = 0;
        char current = 'a';

        for (char c : s.toCharArray()) {
            int distance = Math.abs(c - current);
            rotations += Math.min(distance, 26 - distance);
            current = c;
        }

        System.out.println(rotations);

        scanner.close();
    }
}