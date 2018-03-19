package Assignment7;

import java.util.Arrays;
import java.util.List;

public class RemoveVowels {

    public String removeVowelsFromString(String input) {

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u','A','E','I','O','U');
        StringBuffer sb = new StringBuffer(input);

        for (int i = 0; i < sb.length(); i++) {

            if (vowels.contains(sb.charAt(i))) {

                sb.replace(i, i + 1, "");
                i--;
            }
        }

        return sb.toString();
    }
}