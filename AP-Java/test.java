import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N_ = sc.nextLine();

        int N = Integer.parseInt(N_);

        ArrayList<Integer> days = new ArrayList<Integer>();

        setAllZero(days);

        // {0, 0, 0, 0, 0}

        for (int i = 0; i < N; i++) {
            String avails = sc.nextLine(); // YY.Y.
            for (int j = 0; j < 5; j++) {
                if (avails.charAt(j) == 'Y') {
                    days.set(j, days.get(j) + 1);
                }
            } // {1, 2, 1, 3, 0}
        }

        int maxVal = -1;
        ArrayList<Integer> maxDays = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            int currDayVal = days.get(i);
            if (currDayVal > maxVal) {
                maxDays.clear();
                maxDays.add(i);
                maxVal = currDayVal;
            } else if (currDayVal == maxVal) {
                maxDays.add(i);
            }
        }

        for (int i = 0; i < maxDays.size(); i++) {
            System.out.print(maxDays.get(i) + 1);
            if (i != maxDays.size() - 1) {
                System.out.print(",");
            }
        }

    }

    public static void setAllZero(ArrayList<Integer> arr) {
        arr.clear();
        for (int i = 0; i < 5; i++) {
            arr.add(0);
        }
    }
}
