import java.util.HashMap;
import java.util.Scanner;

public class A_Amusing_Joke {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String guest = sc.next();
        String host = sc.next();
        String pile = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : guest.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : host.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean found = true;

        for(char ch : pile.toCharArray()) {
            if(!map.containsKey(ch)) {
                found = false;
                break;
            }

            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        System.out.println(found && map.size() == 0 ? "YES" : "NO");

        sc.close();
    }
}