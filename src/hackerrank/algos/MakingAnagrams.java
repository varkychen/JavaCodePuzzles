package hackerrank.algos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        Map<Integer,Integer> map = new HashMap<>();
        first.chars().forEach(i -> {
            map.merge(i, 1, (x, y) -> x+y);
        });
        
        second.chars().forEach(i -> {
            map.merge(i, -1, (x, y) -> (x+y == 0 ? null : x+y));
        });
        
        int result = map.values().stream().mapToInt(i -> {
            return Math.abs(i.intValue());
        }).sum();
        return result;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
        in.close();
    }
}