import java.util.*;

public class BoggleSimpleLAB8 {
    static final int SIZE = 4;
    static String[][] board = new String[SIZE][SIZE];
    static boolean[][] visited = new boolean[SIZE][SIZE];

    static Set<String> dictionary = new HashSet<>(Arrays.asList(
            "WIN", "WINE", "KNOW", "KNEW", "THE", "THEN", "FEW", "WORK", "FINE"));

    // To store words found on the board
    static Set<String> found = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 16 letters (space-separated):");
        String[] input = scanner.nextLine().trim().toUpperCase().split("\\s+");

        if (input.length != 16) {
            System.out.println("Please enter exactly 16 letters.");
            return;
        }

        for (int i = 0; i < 16; i++) {
            board[i / 4][i % 4] = input[i];
        }

        // Print the board
        System.out.println("Boggle Board:");
        for (String[] row : board) {
            for (String letter : row) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                dfs(r, c, "");
            }
        }

        System.out.println("\nSome words found:");
        for (String word : found) {
            System.out.println(word);
        }
    }

    static void dfs(int r, int c, String word) {

        if (r < 0 || c < 0 || r >= SIZE || c >= SIZE || visited[r][c])
            return;

        word += board[r][c];

        if (dictionary.contains(word)) {
            found.add(word);
        }

        visited[r][c] = true;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr != 0 || dc != 0) {
                    dfs(r + dr, c + dc, word);
                }
            }
        }

        visited[r][c] = false;
    }
}
