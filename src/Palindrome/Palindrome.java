package Palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cc
 */
public class Palindrome {
    /**
     * IS PALINDROME
     * 
     * TRAVERSE FROM THE ENDS OF THE STRING TO THE MIDDLE, TO DETERMINE IF THE STRING IS A PALINDROME
     * REMOVE ANY SPACES IN CASE IT IS A PHRASE
     * 
     * @param str
     * @return 
     */
    public static boolean isPalindrome(String str) {
        char[] array = str.toCharArray();
        for(int i = 0; i < array.length / 2; i++) {
            if(array[i] != array[array.length-i-1]) {                
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
//        System.out.println("is \"foo\" palindrome?");
        List<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.add("racecar");
        strings.add("job");
        strings.add("mom");
        strings.add("dad");
        strings.add("palindrome");
        strings.add("bobsled");
        strings.add("a man a plan a canal panama");
        strings.add("a toyota");
        
        for(String s : strings) {
            System.out.println("Checking whether " + s + " is palindrome");
            s = s.replaceAll(" ", "");
            if(isPalindrome(s)) {
                System.out.println("IS PALINDROME");
            } else {
                System.out.println("ISN'T PALINDROME");
            }            
        }
        

    }
}
