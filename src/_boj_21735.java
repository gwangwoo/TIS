import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_21735 {
    static int N,M;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        go(0, 0, 1);
        System.out.println(answer);
    }
    static void go(int idx, int cnt, int sum) {
        if(idx >= N || cnt >= M) {
            answer = Math.max(answer, sum);
            return;
        }
        go(idx+1, cnt+1, sum + arr[idx+1]);
        if(idx+2 > N) {
            go(idx+2, cnt+1, sum);
            return;
        }
        go(idx+2, cnt+1, sum / 2 + arr[idx+2]);
    }
}
