import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        Stack<Tower> stk = new Stack<>();
        stk.add(new Tower(0, arr[0]));
        for (int i = 1 ; i < N ; i++) {
            while (!stk.isEmpty() && stk.peek().height < arr[i]) {
                stk.pop();
                if (stk.isEmpty()) { // 스택 내부에 자기보다 큰 타워가 없음
                    stk.add(new Tower(i, arr[i]));
                    break;
                } else if (stk.peek().height > arr[i]) {    // 스택내부에서 자신보다 큰 타워를 만남
                    answer[i] = stk.peek().idx+1;
                    stk.add(new Tower(i, arr[i]));
                    break;
                }
            }
            if (stk.isEmpty()) {
                answer[i] = 0;
            } else if (stk.peek().height > arr[i]) {
            // 스택 top의 tower 높이가 더 현재타워보다 더큼
                answer[i] = stk.peek().idx+1;
            }
            stk.add(new Tower(i, arr[i]));
        }

        for (int i = 0 ; i < N ; i++) {
            System.out.print(answer[i] + " ");
        }

    }
    static class Tower {
        int idx;
        int height;
        Tower(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
}
