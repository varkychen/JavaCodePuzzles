package hackerrank.algos.dp;

public class BestSelfie {

    private static int[][] matrix;
    public static void main(String[] args) {
        String[] result = bestSelfie(new String[] {"A", "B", "C", "D", "E", "C", "B", "A"});
        for(String s : result)
            System.out.print(s + " ");
    }
    static String[] bestSelfie(String[] array) {
        String[] reverse = new String[array.length];
        for (int i=0; i < array.length; i++)
            reverse[i] = array[array.length-1-i];
        
        matrix = new int[array.length+1][reverse.length+1];
        int[] largest = populateMatrix(array, reverse);
        
        int count = matrix[largest[0]][largest[1]];
        String[] result = new String[count];
        for (int i=1; i<=count; i++) {
            result[result.length - i] = array[largest[0]-i];
        }
        return result;
    }
    private static int[] populateMatrix(String[] array, String[] reverse) {
        int[] largestPoint = {1, 1};
        for (int i=1; i <= array.length; i++) {
            for (int j=1; j <= reverse.length; j++) {
                if (array[i-1].equals(reverse[j-1])) {
                    matrix[i][j] =  1 + matrix[i-1][j-1];
                    if (matrix[i][j] > matrix[largestPoint[0]][largestPoint[1]]) {
                        largestPoint = new int[]{i, j};
                    }
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return largestPoint;
    }
}
