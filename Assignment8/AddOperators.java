package Assignment8;

import java.util.ArrayList;
import java.util.List;

public class AddOperators {

    List<String> res = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        helper(num, target, "", 0, 0);
        return res;
    }

    private void helper(String num, int target, String temp, long currRes, long prevNum) {

        if (currRes == target && num.length() == 0) {

            String exp = new String(temp);
            res.add(exp);
            return;
        }

        for (int i = 1; i <= num.length(); i++) {

            String currStr = num.substring(0, i);
            if (currStr.length() > 1 && currStr.charAt(0) == '0')
                return;
            long currNum = Long.parseLong(currStr);
            String next = num.substring(i);
            if (temp.length() != 0) {
                //multiply
                helper(next, target, temp + "*" + currNum, (currRes - prevNum) + prevNum * currNum, prevNum * currNum);
                //add
                helper(next, target, temp + "+" + currNum, currRes + currNum, currNum);
                //minus
                helper(next, target, temp + "-" + currNum, currRes - currNum, -currNum);
            } else {
                helper(next, target, currStr, currNum, currNum);
            }
        }
    }
}
