import java.util.*;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // Populate array with 10,000 ascending values
        for (int i = 0; i < 10000; i++) {
            arr.add(i);
        }

        int numToFind = Integer.parseInt(input("Please enter the number to find from 0-9999 inclusive:\n"));

        int index = binarySearch(arr, numToFind, 0, arr.size());

        System.out.println("\nThe number was at index: " + index);

    }

    public static int binarySearch(ArrayList<Integer> arr, int target, int start, int end) {
        int midPoint = (start + end) / 2;
        if (start >= end) {
            return -1;
        }
        int midVal = arr.get(midPoint);
        if (midVal == target) {
            return midPoint;
        } else if (midVal < target) {
            start = midPoint + 1;
        } else {
            end = midPoint - 1;
        }
        return binarySearch(arr, target, start, end);
    }

    public static String input(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextLine();
    }
}