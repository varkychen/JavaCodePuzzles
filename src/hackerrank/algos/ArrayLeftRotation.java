package hackerrank.algos;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];

        IntStream.range(0, n).forEach(i -> {
            a[(i - k + n) % n] = in.nextInt();
        });
        in.close();

        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
    }
}