
import java.util.Scanner;

public class ChopAndHash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user inputs
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        System.out.print("Enter the number of pieces you want it splitn to: ");
        int n = scanner.nextInt();

        String result = chopAndHash(s, n);
        System.out.println("Output is: " + result);

        scanner.close();
    }

    public static String chopAndHash(String s, int n) {
        int length = s.length(); // Lenght string s
        int chunkSize = length / n; // Calculate the size of each chunk (/2 n(number of pieces))
        String result = "";

        // Loop through the string in da steps of chunkSize
        for (int i = 0; i < length; i += chunkSize) {
            String chunk = s.substring(i, i + chunkSize);
            int sum = 0;

            // gives sum character hash values
            for (char c : chunk.toCharArray()) {
                sum += c - 'a'; // Convert character to hash value (0-25)
            }

            char hashedChar = (char) ('a' + (sum % 26));
            result = result + hashedChar;
        }

        return result;
    }
}