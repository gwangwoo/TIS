import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stk = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder answer = new StringBuilder();
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == '<') {
                stackClear(stk, answer);
                while(true) {
                    answer.append(str.charAt(i));
                    if (str.charAt(i) == '>') {
                        break;
                    }
                    i++;
                }
            } else if (str.charAt(i) == ' ') {
                stackClear(stk, answer);
                answer.append(' ');
            } else {
                stk.add(str.charAt(i));
            }
        }
        stackClear(stk, answer);
        System.out.println(answer);
    }

    private static void stackClear(Stack<Character> stk, StringBuilder answer) {
        while(!stk.isEmpty()) {
            answer.append(stk.pop());
        }
    }
}
