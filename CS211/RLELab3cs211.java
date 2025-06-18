import java.util.Scanner;

public class RLELab3cs211 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string to be compressed: ");

        String input = scanner.nextLine();

        System.out.println("Compressed as: " + compress(input));
        String comp = compress(input);
        double difference = ((double) comp.length() / input.length()) * 100;
        double tot = 100.0;
        if (comp.length() < input.length()) {
            System.out.println(tot - difference + "%");
        } else {
            System.out.println(tot + difference + "%");
        }

        System.out.println("compressed is : " + difference);
    }

    public static String compress(String input) {
        int count = 1;
        String comp = "";

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1))
                count++;
            else {
                comp = comp.concat(Integer.toString(count)).concat(Character.toString(input.charAt(i)));
                count = 1;
            }
        }
        return comp;
    }
}