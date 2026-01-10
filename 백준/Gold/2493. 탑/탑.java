import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            }
            if (stk.isEmpty()) {
                answer[i] = 0;
            } else if (stk.peek().height > arr[i]) {
            // 스택 top의 tower 높이가 더 현재타워보다 더큼
                answer[i] = stk.peek().idx+1;
            }
            stk.add(new Tower(i, arr[i]));
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0 ; i < N ; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
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
