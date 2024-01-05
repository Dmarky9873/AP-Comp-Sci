import java.util.Scanner;

public class GetPositiveDivisors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Integer > 0: ");
        int num = in.nextInt();
        in.close();

        System.out.println("The number you gave was " + num);

        System.out.print("1");

        int counter = num / 2;

        while (counter > 1) {
            if ((num % counter) == 0) {
                System.out.print(", " + counter);
            }
            counter--;
        }

        System.out.print(", " + num);
    }
}