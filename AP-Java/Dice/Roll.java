// Place this file in a folder called "Dice"
package Dice;

import java.util.Random;

// Paste the code in a file within the folder called "Roll.java"
public class Roll {
    public static void main(String[] args) {
        // Creates an instance of the roll class so we can access the dice child class
        Roll r = new Roll();

        // Creates two dice
        Dice dice1 = r.new Dice();
        Dice dice2 = r.new Dice();

        // Rolls the two dice randomizing their values
        dice1.roll();
        dice2.roll();

        // Prints the values along with their sum
        System.out.println("Dice 1 value: " + dice1.getVal());
        System.out.println("Dice 2 value: " + dice2.getVal());        
        System.out.println("Sum: " + (dice1.getVal() + dice2.getVal()));
    }


    private class Dice {
        // Creates an instance of the random class to randomize the value
        Random r = new Random();

        // Creates a variable to store the value of the dice (it starts as null)
        private int val;

        // Creates an ACCESSOR METHOD to read the value of the dice's value
        public int getVal() {
            return val;
        }

        // Creates a MUTATOR METHOD to "roll the dice" (randomize the value variable)
        public void roll() {
            val = r.nextInt(6) + 1;
        }
    }
}