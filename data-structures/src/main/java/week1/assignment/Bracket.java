package week1.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
    char type;
    int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean match(char c) {
        switch (c) {
            case ']':
                return this.type == '[';
            case '}':
                return this.type == '{';
            case ')':
                return this.type == '(';
            default:
                return false;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        String text = reader.readLine();
        CheckBrackets check = new CheckBrackets();
        System.out.println(check.checkString(text));
    }
}

class CheckBrackets {

    static String checkString(String text) {
        int pos = isBalanced(text);
        return pos == -1 ? "Success" : (pos + 1) + "";
    }

    private static int isBalanced(String text) {
        Stack<Bracket> stack = new Stack<>();
        int pos = -1;
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                stack.push(new Bracket(next, position));
            }

            if (next == ')' || next == ']' || next == '}') {
                if (stack.isEmpty()) {
                    pos = position;
                    break;
                }
                Bracket last = stack.pop();
                if (!last.match(next)) {
                    pos = position;
                    break;
                }
            }
        }
        if (pos != -1) {
            return pos;
        } else if (!stack.isEmpty()) {
            return stack.pop().position;
        } else {
            return pos;
        }
    }
}