import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class A_Team_Olympiad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i + 1);
        }

        int size = map.size();

        if(size != 3) {
            System.out.println(0);
            sc.close();
            return;
        }

        int teams = n;
        for (int key : map.keySet()) {
            teams = Math.min(teams, map.get(key).size());
        }
        System.out.println(teams);

        while (teams-- > 0) {
            System.out.print(map.get(1).get(teams) + " ");
            System.out.print(map.get(2).get(teams) + " ");
            System.out.print(map.get(3).get(teams));
            System.out.println();
        }


        sc.close();
    }
}