
import java.util.Scanner;

public class lab1CS211 {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int[] height = new int[sc.nextInt()];
        System.out.println("Enter heights: ");
        for (int i = 0; i < height.length; i++)
            height[i] = sc.nextInt();
        sc.close();
        System.out.println("Maximum water: " + maxArea(height));
    }
}