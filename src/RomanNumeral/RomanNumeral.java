package RomanNumeral;

import java.util.TreeMap;

public class RomanNumeral {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }
    /**
     * TO ROMAN NUMERALS
     * 
     * USE A TREEMAP TO FIND THE GREATEST KEY GREATER THAN OR EQUAL TO THE NUMBER
     * THEN RECURSE UNTIL THE ENTIRE NUMBER IS REPRESENTED IN ROMAN NUMERALS
     * 
     * @param number
     * @return 
     */
    public final static String toRoman(int number) {
        int l =  map.floorKey(number);  // GET THE GREATEST KEY <= THE NUMBER
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l); // RECURSIVELY CALL WITH REMAINING VALUE
    }
    /**
     * TO ROMAN NUMERALS (FLOATING POINT)
     * 
     * DIVIDE ON THE DECIMAL AND CREATE A ROMAN NUMERAL FOR THE INTEGER PORTION AND ANOTHER FOR THE FLOATING POINT PORTION
     * 
     * @param number
     * @return 
     */
    public final static String toRoman(Float number) {
        String floatString = Float.toString(number);
        String intSubStr = floatString.substring(0,floatString.indexOf("."));
        String floatSubStr = floatString.substring(floatString.indexOf(".") + 1);
        System.out.println("intSubStr=" + intSubStr + ", floatSubStr=" + floatSubStr);
        Integer intPortion = Integer.parseInt(intSubStr);
        Integer floatPortion = Integer.parseInt(floatSubStr);

        return toRoman(intPortion) + '.' + toRoman(floatPortion);
    }

    public static void main(String[] args) {
     System.out.println("1984 in roman numerals = " + toRoman(1984));
     System.out.println("1984.1985 in roman numerals = " + toRoman(1984.1985f));
    }
}