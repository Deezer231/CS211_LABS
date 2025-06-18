
import java.util.Scanner;

public class ChopAndHash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user inputs
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        System.out.print("Enter the number of pieces: ");
        int n = scanner.nextInt();

        // Compute and display the result
        String result = chopAndHash(s, n);
        System.out.println("Output: " + result);

        scanner.close();
    }

    public static String chopAndHash(String s, int n) {
        int length = s.length(); // Get the total length of the string
        int chunkSize = length / n; // Calculate the size of each chunk
        String result = ""; // Initialize an empty result string

        // Loop through the string in steps of chunkSize
        for (int i = 0; i < length; i += chunkSize) {
            String chunk = s.substring(i, i + chunkSize); // Extract the substring
            int sum = 0; // Variable to store sum of hash values

            // Compute the sum of character hash values
            for (char c : chunk.toCharArray()) {
                sum += c - 'a'; // Convert character to hash value (0-25)
            }

            // Compute the final character and update result
            char hashedChar = (char) ('a' + (sum % 26)); // Convert sum % 26 back to a character
            result = result + hashedChar; // Concatenate character to result
        }

        return result; // Return the final transformed string
    }
}