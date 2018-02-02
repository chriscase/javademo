package Ackermann;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author cc
 */
public class Ackermann {
    public static HashMap<String, Integer> ackermannSolutions = new HashMap<String, Integer>();
    /**
     * ACKERMANN FUNCTION
     * 
     * BARE BONES ACKERMANN FUNCTION
     * 
     * @param m
     * @param n
     * @return 
     */
    public static int ackermann(int m, int n) {
        System.out.println("BEGIN: ackermann(" + m + "," + n + ")");
        if(m < 0 || n < 0) {
            throw new Error("both m and n must be greater than or equal to 0");
        }
        if(ackermannSolutions.containsKey(m + "," + n)) {
            System.out.println("solution for ackermann(" + m + "," + n + ") already computed, returning " + ackermannSolutions.get(m + "," + n));
            return ackermannSolutions.get(m + "," + n);
        }
        if(m == 0) {
            System.out.println("saving solution for ackermann(" + m + ", " + n + ") =" + n + 1);
            ackermannSolutions.put(m + "," + n , n + 1);
            System.out.println("returning " + (n + 1));
            return n + 1;
        }
        if(n == 0) {
            System.out.println("recursively calling ackermann(" + (m - 1) + "," + (1) + ")");
            return ackermann(m - 1, 1);
        } else {
            System.out.println("recursively calling ackermann(" + (m) + "," + (n - 1) + ")");
            return ackermann(m-1, ackermann(m, n-1));
        }
    }
    /**
     * ACkERMANN WITH CACHED SOLUTIONS
     * 
     * SAVE THE KNOWN SOLUTIONS INTO A HASHMAP TO OPTIMIZE ACKERMANN
     * 
     * @param m
     * @param n
     * @return 
     */
    public static int ackermannWithCachedSolutions(int m, int n) {
        System.out.println("BEGIN: ackermannWithCachedSolutions(" + m + "," + n + ")");
        if(m < 0 || n < 0) {
            throw new Error("both m and n must be greater than or equal to 0");
        }
        if(ackermannSolutions.containsKey(m + "," + n)) {
            System.out.println("solution for ackermann(" + m + "," + n + ") already computed, returning " + ackermannSolutions.get(m + "," + n));
            return ackermannSolutions.get(m + "," + n);
        }
        if(m == 0) {
            System.out.println("saving solution for ackermann(" + m + ", " + n + ") =" + n + 1);
            ackermannSolutions.put(m + "," + n , n + 1);
            System.out.println("returning " + (n + 1));
            return n + 1;
        }
        if(n == 0) {
            System.out.println("recursively calling ackermann(" + (m - 1) + "," + (1) + ")");
            return ackermannWithCachedSolutions(m - 1, 1);
        } else {
            System.out.println("recursively calling ackermann(" + (m) + "," + (n - 1) + ")");
            return ackermannWithCachedSolutions(m-1, ackermannWithCachedSolutions(m, n-1));
        }
    }
    /**
     * ACKERMANN WITHOUT RECURSION
     * 
     * USE A STACK TO REPLACE RECURSION IN THE ACKERMANN ALGORITHM
     * 
     * @param m
     * @param n
     * @return 
     */
    public static int ackermannWithoutRecursion(Integer m, Integer n) {
        System.out.println("BEGIN: ackermannWithoutRecursion(" + m + "," + n + ")");
        Stack<Integer> s = new Stack();
        s.add(m);
        while(!s.isEmpty()) {
            m = s.pop();
            if(m == 0 || n == 0) {
                n += m + 1;
            } else {
                s.add(--m);
                s.add(++m);
                n--;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        System.out.println("ackermann(1,2)=" + ackermann(1,2));
//        System.out.println("ackermann(4,3)=" + ackermann(4,3));
        System.out.println("ackermannWithCachedSolutions(1,2)=" + ackermannWithCachedSolutions(1,2));
//        System.out.println("ackermannWithCachedSolutions(4,3)=" + ackermannWithCachedSolutions(4,3));
        System.out.println("ackermannWithoutRecursion(1,2)=" + ackermannWithoutRecursion(1,2));
    }
}
