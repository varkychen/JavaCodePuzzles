package hackerrank.algos.dp;

import java.util.Scanner;

public class RedJohnIsBack {
    /*
     * Serial killer Red John has committed a murder and has agreed to turn himself in if
     * you can solve this puzzle. You need to open a safe which contains the phone number
     * to call Red John. Also, there is a 4 X N brick wall and infinite supply of 1 X 4
     * brick and 4 X 1 bricks. The combination to open the safe M is the number of possible
     * ways to arrange the two types of bricks for a given N on the 4 X N brick wall such
     * that the brick wall is completely covered. Red John, who gained a master's degree
     * in Maths in jail, wants you to answer with the number of primes P up to M. Otherwise
     * another murder will happen in a week.
     * 
     * Inputs - Two lines of input T test cases followed by T lines containing an integer N
     * Output - For each input N, output the number P
     * 
     * 1<=T<=20
     * 1<=N<=40
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        for(int i=0; i<T; i++) {
            int n = s.nextInt();
            int p = solveRiddle(n);
            System.out.println(p);
        };
        
        s.close();
    }

    private static int solveRiddle(int n) {
        int M = arrangeBricks(n);
        int primes = primesUpto(M);
        return primes;
    }
    
    private static int arrangeBricks(int n) {
        int sum = 0;
        int fours = 0;
        int temp = n;
        do {
            sum += combinationOfBricks(temp, fours);
            temp -= 4;
            fours++;
        } while(temp >= 0);
        return sum;
    }

    private static int combinationOfBricks(int temp, int fours) {
        if(temp == 0 || fours == 0)
            return 1;
        if(fours == 0 && temp < 4)
            return 1;
        
        int n = temp + fours;
        int loops = Math.min(temp, fours);
        int product=1;
        for(int i=1; i<=loops; i++) {
            product *= n;
            product /= i;
            n--;
        }
        return product;
    }

    private static int primesUpto(int m) {
        if (m <= 1) return 0;
        if (m < 4) return m-1;
        
        int count = m-1;
        int[] data = new int[m+1];
        data[0] = data[1] = 1;
        
        for(int i=2; i*i <= m; i++) {
            if(data[i] == 1) continue;
            for(int j = 2*i; j<=m; j += i) {
                if(data[j] != 1) {
                    data[j] = 1;
                    count--;
                }
            }
        }
        return count;
    }
}
