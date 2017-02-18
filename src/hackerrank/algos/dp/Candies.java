package hackerrank.algos.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Candies {
    /*
     * A Teacher wants to distributes the minimum number of sweets to children in her class.
     * Criteria
     *   1.) Each child should get atleast 1 candy
     *   2.) Child with higher rank sitting next to lower rank child gets more candy
     *   
     * Inputs
     *   1.) N, the number of children in the class, 1 <= N <= 10^5
     *   2.) N lines of integer indicating rank of each child, 1 <= rank <= 10^5
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ranks = new int[n+2];
        ranks[0] = ranks[ranks.length-1] = Integer.MAX_VALUE;
        
        candies = new int[n];
        for(int i=1; i<ranks.length-1; i++)
            ranks[i] = in.nextInt();
        in.close();
        
        updateCandies();
        
        System.out.println(Arrays.stream(candies).asLongStream().sum());
    }
    
    private static void updateCandies() {
        for(int i=0; i<candies.length; i++) {
            int r = i + 1;
            if(ranks[r-1] >= ranks[r]) {
                if(ranks[r+1] >= ranks[r])
                    candies[i] = 1;
                else {
                    int j = updateTillValley(i);
                    candies[i] = 1 + candies[i+1];
                    i=j;
                }
            } else {
                if(ranks[r+1] < ranks[r]) {
                    int j = updateTillValley(i);
                    candies[i] = 1 + Math.max(candies[i-1], candies[i+1]);
                    i=j;
                } else 
                    candies[i] = 1 + (i>0 ? candies[i-1] : 0);
            }
        }
    }

    private static int updateTillValley(int i) {
        int j = i+1;
        
        for(; j<ranks.length-1 && ranks[j+1] < ranks[j]; j++) ;
        
        int l=j-1;
        candies[l] = 1;
        for(int k=l-1; k>i; k--)
            candies[k] = 1 + candies[k+1];
        return l;
    }

    private static int[] candies;
    private static int[] ranks;
}
