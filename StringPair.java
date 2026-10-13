
import java.util.Scanner;

public class StringPair {

    // Arrays mapping numbers to words
    static String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
                            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
                            
    static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    // Function to get the lowercase English word for numbers 1 to 100
    public static String getWord(int num) {
        if (num == 100) {
            return "hundred"; // Explicit rule from the problem
        }
        if (num < 20) {
            return ones[num];
        }
        // Combines tens and ones (e.g., 21 -> tens[2] + ones[1] = "twenty" + "one")
        return tens[num / 10] + ones[num % 10]; 
    }

    // Function to count vowels in a given string
    public static int getVowelCount(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Ensure input exists before reading
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        
        // Read N (number of elements)
        int n = sc.nextInt();
        
        // Read array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Step 1 & 2: Calculate target sum D[cite: 1]
        int D = 0;
        for (int i = 0; i < n; i++) {
            String word = getWord(arr[i]);
            D += getVowelCount(word); // Accumulate all vowels into D[cite: 1]
        }
        
        // Step 3: Count unordered valid pairs that sum to D[cite: 1]
        int pairCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // j = i + 1 ensures pairs are unordered and not duplicated
                if (arr[i] + arr[j] == D) {
                    pairCount++;
                }
            }
        }
        
        // Step 4: Output the result as a textual representation[cite: 1]
        if (pairCount > 100) {
            System.out.println("greater 100"); // Constraint if count exceeds 100[cite: 1]
        } else if (pairCount == 0) {
            System.out.println("zero"); // Special handler for zero count
        } else {
            System.out.println(getWord(pairCount)); // Converts the final int count back to words[cite: 1]
        }
        
        sc.close();
    }
}
