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

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.close();

        int[] newA = new int[n];
        IntStream.range(0, n).forEach(i -> newA[(i - k + n) % n] = a[i]);
        Arrays.stream(newA).forEach(i -> System.out.print(i + " "));
    }
}