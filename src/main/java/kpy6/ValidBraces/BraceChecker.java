package kpy6.ValidBraces;

import java.util.Stack;

public class BraceChecker {

    //"  (){}[]"   =>  True
    //"  ([{}])"   =>  True
    //"  (}"       =>  False
    //"  [(])"     =>  False
    //"  [({})](]" =>  False

    public boolean isValid(String braces) {
        Stack<Character> in = new Stack<>();
        int previous = 0;
        char[] chars = braces.toCharArray();
        for (Character c : chars) {
            if (chars[0] == 41 || chars[0] == 125 || chars[0] == 93) {
                return false;
            }
            in.push(c);
            if ((previous) == getOpus(c)) {
                in.pop();
                in.pop();
                if (!in.empty())
                    previous = in.peek();
                else
                    previous = 0;
                continue;
            }
            previous = c;
        }
        return in.empty();
    }

    public int getOpus(int bracket) {
        switch (bracket) {
            case 40:
                return 41;
            case 41:
                return 40;
            case 123:
                return 125;
            case 125:
                return 123;
            case 91:
                return 93;
            case 93:
                return 91;
            default:
                return 0;
        }
    }
}
