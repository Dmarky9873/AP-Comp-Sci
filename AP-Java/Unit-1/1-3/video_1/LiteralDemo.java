/*
 * Programmer: Daniel Markusson
 * Date 2023-10-06
 * Purpose Demonstrate literals and expressions
 */

public class LiteralDemo {
    public static void main(String[] args) {
        /*
         * Literal vs. String literal
         * Literal - The source code representation of a fixed value. (3)
         * String literal(1.1) - Enclosed in double quotes. ("3")
         */
        System.out.println(3);
        System.out.println("3");
        // Above two both print 3

        System.out.println(3 + 3);
        // Above prints 6
        
        System.out.println("3" + "3");
        // Above prints 33

    }
 }