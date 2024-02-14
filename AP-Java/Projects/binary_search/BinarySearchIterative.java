import java.util.*;

public class BinarySearchIterative {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // Fill array with 10,000 ascending values
        for (int i = 0; i < 10000; i++) {
            arr.add(i);
        }

        int numToFind = Integer.parseInt(input("Please enter the number to find from 0-999 inclusive:\n"));

        int index = binarySearch(arr, numToFind);

        System.out.println("\nThe number was at index: " + index);

    }

    public static int binarySearch(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size();
        int midVal;
        int midPoint;
        while (start < end) {
            midPoint = (start + end) / 2;
            midVal = arr.get(midPoint);
            if (midVal == target) {
                return midPoint;
            } else if (midVal < target) {
                start = midPoint + 1;
            } else {
                end = midPoint - 1;
            }
        }
        return -1;
    }

    public static String input(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextLine();
    }
}
