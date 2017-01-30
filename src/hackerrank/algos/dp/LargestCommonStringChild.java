package hackerrank.algos.dp;
import java.util.Scanner;

public class LargestCommonStringChild {

    private String a;
    private String b;
    private int[][] matrix;
    
    public LargestCommonStringChild(String a, String b) {
        this.a = a;
        this.b = b;
        matrix = new int[a.length()][b.length()];
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[i].length; j++)
                matrix[i][j] = -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.next();
        String b = s.next();
        s.close();
        
        int maxSum = new LargestCommonStringChild(a, b).getLCS();
        System.out.println(maxSum);
    }

    int getLCS() {
        int lcs = calculateLCS(a.toCharArray(), b.toCharArray(), a.length(), b.length());
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++)
                System.out.print(matrix[i][j] == -1 ? "n" : matrix[i][j]);
            System.out.println();
        }
        System.out.println();
        return lcs;
    }

    private int calculateLCS(char[] a, char[] b, int m, int n) {
        if (m==0 || n==0)
            return 0;
        else {
            if (matrix[m-1][n-1] != -1)
                return matrix[m-1][n-1];
            
            char a1 = a[m-1];
            char b1 = b[n-1];
            
            if (a1 == b1) 
                matrix[m-1][n-1] = 1 + calculateLCS(a,b,m-1,n-1);
            else 
                matrix[m-1][n-1] = Math.max(calculateLCS(a,b,m-1,n), calculateLCS(a,b,m,n-1));
            
            return matrix[m-1][n-1];
        }
    }
}