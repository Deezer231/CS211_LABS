import java.util.Scanner;

public class HexidecimalToRoman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Hex string: ");

        String hex = scanner.nextLine();

        String roman = getRoman(hex);

        System.out.println(roman);

    }

    public static String getRoman(String hex) {
        int num = Integer.parseInt(hex, 16); // Convert hex to decimal -LINK
        return convertToRoman(num);
    }

    public static String convertToRoman(int num) {
        String roman = "";

        int M = 1000;
        int D = 500;
        int C = 100;
        int L = 50;
        int X = 10;
        int V = 5;
        int I = 1;

        while (num >= M) { // bigger or EQUAL than 1000
            roman += "M"; // m is added to empty string
            num -= M; // take the value of M(1000) from the num variable
        }
        while (num >= D) {
            roman += "D";
            num -= D;
        }
        while (num >= C) {
            roman += "C";
            num -= C;
        }
        while (num >= L) {
            roman += "L";
            num -= L;
        }
        while (num >= X) {
            roman += "X";
            num -= X;
        }
        while (num >= V) {
            roman += "V";
            num -= V;
        }
        while (num >= I) {
            roman += "I";
            num -= I;
        }

        return roman; // return roman numeral
    }
}