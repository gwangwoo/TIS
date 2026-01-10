import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());


            while (!stk.isEmpty() && stk.peek() > height) {
                stk.pop();
            }
            if (stk.isEmpty() || stk.peek() < height) {
                stk.add(height);
                if (height != 0) answer++;
            }
        }
        System.out.println(answer);
    }
}
