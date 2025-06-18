import java.util.Scanner;

public class ElGamalLABBOB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bob's private key
        System.out.println("Enter your private key (p x):");
        int p = scanner.nextInt(); // same prime as Alice used
        int x = scanner.nextInt(); // Bob's secret number

        // enter ciphertext
        System.out.println("Enter the ciphertext (c1 c2):");
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();

        // get shared secret = COPY
        int s = 1;
        for (int i = 0; i < x; i++) {
            s = (s * c1) % p; // s = c1^x mod p
        }

        // Find modular inverse of s (brute-force method = COPY)
        int sInv = 0;
        for (int i = 1; i < p; i++) {
            if ((s * i) % p == 1) {
                sInv = i;
                break;
            }
        }

        // Decrypt
        int m = (c2 * sInv) % p;

        System.out.println("Decrypted message from Alice:");
        System.out.println(m);
    }
}