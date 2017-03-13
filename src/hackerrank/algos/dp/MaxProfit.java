package hackerrank.algos.dp;

import java.util.Scanner;

public class MaxProfit {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] data = new int[n];
    
    for(int i=0; i<n; i++)
        data[i] = in.nextInt();
    in.close();
  
    System.out.println(getProfit(data));
  }
  
    public static long getProfit(int[] data) {
        long[] resultArray = new long[data.length];
        long largest = 0;
        for(int i=0; i<data.length; i++) {
            if(i==0) {
                resultArray[i] = Math.max(0, data[i]);
                largest = resultArray[i];
            } else {
                resultArray[i] = Math.max(0, resultArray[i-1] + data[i]);
                largest = Math.max(largest, resultArray[i]);
            }
        }
        
        // for(int i=0; i<resultArray.length; i++)
        //     System.out.print(resultArray[i] + " ");
        return largest;
    }
}