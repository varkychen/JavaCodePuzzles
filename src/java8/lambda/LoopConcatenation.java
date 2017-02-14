package java8.lambda;

import java.util.stream.IntStream;

public class LoopConcatenation {

    public static void main(String[] args) {
        String value = IntStream.range(0, 5).mapToObj(x -> "y").reduce(String::concat).get();
        System.out.println(value);
    }

}
