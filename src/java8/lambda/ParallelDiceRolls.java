package java8.lambda;

import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.groupingBy;

import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class ParallelDiceRolls {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double fraction = 1.0/N;
        
        IntFunction<Integer> twoDiceThrows = i -> {
          Random rand = new Random();
          int j = rand.ints(1, 7).findFirst().getAsInt();
          int k = rand.ints(1, 7).findFirst().getAsInt();
          return j+k;
        };
        
        System.out.println(IntStream
                            .range(0, N)
                            .parallel()
                            .mapToObj(twoDiceThrows)
                            .collect(groupingBy(i -> i,
                                        summingDouble(n -> fraction))));
    }
}
