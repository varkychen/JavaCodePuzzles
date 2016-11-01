package hackerrank.algos;

import java.util.Arrays;
import java.util.Scanner;

public class MakingAnagrams {
    private static final int ALPHABETS = 26;
    
    public static int numberNeeded(String first, String second) {
        int[] count = new int[ALPHABETS];
        first.chars().forEach(i -> count[i%ALPHABETS]++);
        second.chars().forEach(i -> count[i%ALPHABETS]--);
        return Arrays.stream(count).map(Math::abs).sum();
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
        in.close();
    }
}