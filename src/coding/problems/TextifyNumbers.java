package coding.problems;

import java.util.Scanner;

public class TextifyNumbers {
    public static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static final String[] TEENS = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static final String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLong()) {
            int input = in.nextInt();
            textify(input);
        }
        in.close();
    }

    private static void textify(int input) {
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while(input > 0) {
            int hundreds = input % 1000;
            
            String output = "";
            boolean isTeen = false;
            boolean needSpace = false;
            boolean needAnd = false;
            if (hundreds > 0) {
                int h = hundreds / 100;
                if(h > 0) {
                    output += ONES[h] + " Hundred";
                    needAnd = true;
                    needSpace = true;
                }
                
                int tens = hundreds % 100;
                int t = tens / 10;
                if(t > 1) {
                    output += (needSpace ? " " : "") + (needAnd ? "and " : "") + TENS[t];
                    needAnd = false;
                    needSpace = true;
                } else if (t == 1) {
                    isTeen = true;
                }
                
                int ones = tens % 10;
                if(isTeen) {
                    output += (needSpace ? " " : "") + (needAnd ? "and " : "") + TEENS[ones];
                } else {
                    output += (needSpace ? " " : "") + (needAnd ? "and " : "") + ONES[ones];
                }
            }
            
            String suffix = (i == 0 ? "" : i == 1 ? "Thousand" : "Million");
            if(hundreds > 0)
                buffer.insert(0,output + " " + suffix + " ");
            input /= 1000;
            i++;
        }
        System.out.println(buffer.toString());
    }
}
