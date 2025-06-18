import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoaderLAB3 {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();

        try (Scanner scan = new Scanner(new File("C:\\wordFrequencies.txt"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String word = line.split(" ")[0];

                // Add only if it doesn't contain right-hand side letters
                if (!word.matches(".*[yuiophjklnm].*")) {
                    input.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found");
            return;
        }

        System.out.println("File loaded with " + input.size() + " valid lines");
        input.stream().limit(10).forEach(System.out::println);
    }
}
