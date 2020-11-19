package problems;

import java.util.Stack;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a>
 */
public class ValidParentheses {

    public static void main(String... args) {

        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    /**
     * @param s
     * @return boolean
     * <p>
     * Iterate over the character array and whenever we encounter an opening bracket, we store in the stack. Stack is used
     * here, as we can pop the last in opening bracket whenever we encounter a closing bracket. This enables us to compare
     * adjacent opening and closing brackets (and not two adjacent characters).
     * <p>
     * Now, whenever we encounter a closing bracket, we pop the last in opening bracket and check if they are matching (matching
     * here means the opening bracket is closed by its valid closing bracket). It not we return false. When all the elements
     * of the character array have been processed, we return if the stack is empty or not. If the stack is empty that means the
     * String is a valid is as all opening brackets were popped out and they have there matching closing bracket. If the stack
     * is not empty that means the String is not valid.
     */
    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;

        //Assumption - String only contains '{', '[', '(', '}', ']', ')' characters.
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if ((c == '{') || (c == '[') || (c == '(')) stack.add(c);

            if ((c == '}') || (c == ']') || (c == ')')) {
                if (stack.isEmpty()) return false;

                char op = stack.pop();
                if (op != '{' && c == '}') return false;
                if (op != '[' && c == ']') return false;
                if (op != '(' && c == ')') return false;
            }
        }

        return stack.isEmpty();
    }
}
