/*
 * Programmer: Daniel Markusson
 * Date: 2023-10-06
 * Purpose: Demonstrate syntax and logic errors
 */

public class FindTheBugs {
    public static void main(String[] args) {
        System.out.print("This ");
        System.out.print("is a ");
        System.out.println("test.");
        System.out.print("AP CS ");
        System.out.print("A Rocks");
        System.out.println("!!");

        /*
         * Expected output:
         * This is a test.
         * AP CS A Rocks!!
         */
    }
}
