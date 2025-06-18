import java.util.Random;
import java.util.Scanner;

public class ElGamalLAB7ALICE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bob's public key
        System.out.println("Enter Bob's public key (p g g^x) separated by spaces:");
        int p = scanner.nextInt(); // p
        int g = scanner.nextInt(); // generator (g)
        int gx = scanner.nextInt(); // g^x mod p

        // Message to encrypt
        System.out.println("Enter your secret number (message):");
        int m = scanner.nextInt();

        // Random number for encryption
        Random rand = new Random();
        int y = 1 + rand.nextInt(p - 2); // between 1 and p-2

        // ciphertext parts
        int c1 = 1;
        for (int i = 0; i < y; i++) {
            c1 = (c1 * g) % p; // c1 = g^y mod p
        }

        int s = 1;
        for (int i = 0; i < y; i++) {
            s = (s * gx) % p; // s = (g^x)^y mod p
        }

        int c2 = (m * s) % p; // c2 = m*s mod p

        System.out.println("Send this ciphertext to Bob:");
        System.out.println(c1 + " " + c2);
    }
}