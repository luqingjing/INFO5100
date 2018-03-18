// scores : 2 / 2
package Assignment5;

import java.util.*;

public class IsValidBrackets {

    public static boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (map.containsKey(curr))
                stack.push(curr);

            else if (map.containsValue(curr)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == curr)
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("([])[]{()}"));
    }
}
