package csYa_ronny;

public class UniqueSubstring {
    public static void main(String[] args) {
        String input = "abcabcbb";  // Example input
        System.out.println("Longest unique substring: " +
                longestUniqueSubstring(input));
    }

    public static String longestUniqueSubstring(String input) {
        int[] last = new int[128]; //ascii table all chars
        for (int i = 0; i < 128; i++) {
            last[i] = -1;//set every charter as -1
        }
        int left = 0;
        int maxLength = 0;
        int start = 0;
        for (int right = 0; right < input.length(); right++)
        {
            char currently = input.charAt(right);//set the char as the current char in the given string
            if (last[currently] >= left)//checks if we have seen it already by checking if the value was changed previously
            {
            left = last[currently] + 1;
            }
            last[currently] = right;//set it as the place we are currently in the loop,used for the return later by Arranging them by numbers
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }
        return input.substring(start, start + maxLength);

    }
}