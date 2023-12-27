package kpy6;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring  <br>
 * Example 1:  <br>
 * <p>
 * Input: s = "(()"  <br>
 * Output: 2  <br>
 * Explanation: The longest valid parentheses substring is "()".  <br>
 * Example 2:  <br>
 * <p>
 * Input: s = ")()())"  <br>
 * Output: 4  <br>
 * Explanation: The longest valid parentheses substring is "()()".  <br>
 * Example 3:  <br>
 * <p>
 * Input: s = ""  <br>
 * Output: 0  <br>
 * Constraints:  <br>
 * 0 <= s.length <= 3 * 104  <br>
 * s[i] is '(', or ')'.  <br>
 */
public class LongestValidParentheses {
    //     (   (   )
    public static int validParentheses(String string) {
        char[] charArray = string.toCharArray();
        int count = 0;

        for (int index = 0; index < charArray.length; index++) {
            char charAtIndex = charArray[index];
            if (charAtIndex == '(') {
                for (int secondIndex = index + 1; secondIndex < charArray.length; secondIndex++) {
                    char charAtSecondIndex = charArray[secondIndex];
                    if (charAtIndex == '(' && charAtSecondIndex == ')') {
                        System.out.println(charArray[index] + "" + charArray[secondIndex]);
                        charArray[index] = 'X';
                        charArray[secondIndex] = 'X';
                        count += 2;
                        break;
                    }
                }
            }
        }

        return count;
    }
}
