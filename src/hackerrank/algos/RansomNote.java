package hackerrank.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * Given a magazine, can we cut out words and use it to replace a
 * case-sensitive Ransom Note ?
 */

public class RansomNote {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int magazineWordCount = in.nextInt();
        int messageWordCount = in.nextInt();
        if (magazineWordCount < messageWordCount) {
            System.out.println("No");
            in.close();
            return;
        }
        
        String magazine[] = new String[magazineWordCount];
        IntStream.range(0, magazineWordCount).forEach(i -> magazine[i] = in.next());

        String ransom[] = new String[messageWordCount];
        IntStream.range(0, messageWordCount).forEach(i -> ransom[i] = in.next());
        in.close();
        
        Map<String, Integer> counts = new HashMap<>();
        Arrays.stream(ransom).forEach(s -> counts.merge(s, 1, (x, y) -> x+y));
        Arrays.stream(magazine).forEach(s -> counts.computeIfPresent(s, (x, y) -> (y == 1 ? null : y - 1)));
        System.out.println(counts.size() == 0 ? "Yes" : "No");
    }
}
