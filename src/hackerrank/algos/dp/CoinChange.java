package hackerrank.algos.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = s.nextInt();
        int n = s.nextInt();
        
        coins = new int[n];
        matrix = new long[n+1][sum+1];
        
        for (int i=0; i<coins.length; i++) 
            coins[i] = s.nextInt();
        s.close();
        
        Arrays.sort(coins);
        
        long count = changeCombo(sum);
        System.out.println(count);
    }

    private static long changeCombo(int sum) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0;j<matrix[i].length; j++) {
                if (j==0)
                    matrix[i][j] = 1;
                else if (i==0 & j > 0)
                    matrix[i][j] = 0;
                else {
                    int newj = j - coins[i-1];
                    matrix[i][j] = matrix[i-1][j] + (newj < 0 ? 0 : matrix[i][newj]);
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix[coins.length][sum];
    }
    static int[] coins;
    static long[][] matrix;
}
