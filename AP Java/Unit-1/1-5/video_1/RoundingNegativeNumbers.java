public class RoundingNegativeNumbers {
    public static void main(String[] args) {
        double number = 11.0 / 4;
        double negativeNumber = -number;
        int roundedNegativeNumber = (int) (negativeNumber - 0.5);
        System.out.print("-11.0 / 4 rounded = ");
        System.out.println(roundedNegativeNumber);
    }
}
