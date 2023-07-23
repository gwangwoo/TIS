import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_27940 {
    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int sum = 0;
        int idx = -1;
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sum += r;
            if(K < sum) {
                idx = i+1;
                break;
            }
        }
        if(idx == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(idx + " " + 1);
    }
}
