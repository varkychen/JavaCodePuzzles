package hackerrank.algos;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.next();
        }
        in.close();
        
        Arrays.stream(arr).forEach(s -> {
            char[] letters = s.toCharArray();
            int pivot = -1;
            int suffixStart = -1;
            for (int i=letters.length-2; i>=0; i--) {
                if (letters[i] < letters[i+1]) {
                    suffixStart = i+1;
                    pivot = i;
                    break;
                }
            }
            if (suffixStart == -1) {
                System.out.println("no answer");
            } else {
                for (int i=letters.length-1; i>=suffixStart; i--) {
                    if(letters[i] > letters[pivot]) {
                        swap(letters, pivot, i);
                        break;
                    }
                }
                
                int mid = (letters.length - 1 - suffixStart)/2;
                for (int i=0; i<=mid; i++)
                    swap(letters, suffixStart+i, letters.length-1-i);
                System.out.println(new String(letters));
            }
        });
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}