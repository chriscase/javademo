package AsciiToInteger;

import java.util.TreeMap;

/**
 *
 * @author cc
 */
public class AsciiToInteger {
    /**
     * ASCII TO INTEGER
     * 
     * CONVERT AN ASCII STRING TO AN INTEGER
     * 
     * @param asciiCharacters
     * @return 
     */
    public static int asciiToInteger(String asciiCharacters) {
        char[] arr = asciiCharacters.toCharArray();
        int zeroAscii = 48;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!Character.isDigit(arr[i])) {
                throw new Error("Not a number");
            }
            
            sum = (sum * 10) + (arr[i] - zeroAscii);                
        }
        return sum;
    }
    /**
     * ASCII TO INTEGER WITHOUT MULTIPLICATION
     * 
     * CONVERT AN ASCII STRING TO AN INTEGER WITHOUT THE USER OF MULTIPLICATION
     * INSTEAD USE BIT SHIFTING
     * 
     * @param asciiCharacters
     * @return 
     */
    public static int asciiToIntegerWithoutMultiplication(String asciiCharacters) {
        char[] arr = asciiCharacters.toCharArray();
        int zeroAscii = 48;
        int result = 0;

        for(int i = 0; i < arr.length; i++) {
            if(!Character.isDigit(arr[i])) {
                throw new Error("Not a number");
            }
            // BIT SHIFT BY 3 TU MULTIPLY BY 8 THEN ADD BIT SHIFT BY 1 TO ADD MULTIPLICATION BY 2, TOTALING 10
            System.out.println("result=" + result + "result shifted=" + ((result << 3) + (result << 1)));
            int resultX10ByShifting = ((result << 3) + (result << 1));
            result = resultX10ByShifting + (arr[i] - zeroAscii);                
        }
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("ASCII TO INTEGER: ASCII=123 INTEGER=" + asciiToInteger("123"));
        System.out.println("ASCII TO INTEGER: ASCII=987654321 INTEGER=" + asciiToInteger("987654321"));
        System.out.println("ASCII TO INTEGER WITHOUT MULTIPLICATION: ASCII=123 INTEGER=" + asciiToIntegerWithoutMultiplication("123"));
        System.out.println("ASCII TO INTEGER WITHOUT MULTIPLICATION: ASCII=987654321 INTEGER=" + asciiToIntegerWithoutMultiplication("987654321"));
    }
    
}
