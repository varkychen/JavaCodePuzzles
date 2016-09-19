package hackerrank.algos;

import java.util.Scanner;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        double positive = 0d;
        double negative = 0d;
        double zeroes = 0d;
        
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if (number > 0d) positive++;
            if (number < 0d) negative++;
            if (number == 0d) zeroes++;
        }
        
        System.out.printf("%.6f%n", positive/n);
        System.out.printf("%.6f%n", negative/n);
        System.out.printf("%.6f%n", zeroes/n);
        scanner.close();
    }
}