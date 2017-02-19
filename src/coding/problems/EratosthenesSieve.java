package coding.problems;

import java.util.Scanner;
import java.util.stream.IntStream;

public class EratosthenesSieve {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        System.out.println(primesLessThan(n));
    }

    private static int primesLessThan(int n) {
        int count=n-1;
        int[] numbers = new int[n+1];
        numbers[0]=numbers[1]=1;
        for(int i=2; i*i <= n; i++) {
            if(numbers[i] == 1)
                continue;
            for(int j=2; i*j <=n; j++) {
                int p=i*j;
                if(numbers[p] != 1) {
                    numbers[p] = 1;
                    count--;
                }
            }
        }
        
        IntStream.range(0, n+1).filter(i -> numbers[i] == 0).forEach(i -> System.out.println(i));
        return count;
    }
}
