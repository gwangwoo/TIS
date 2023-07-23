import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_1590 {
    static int N,T;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][3];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = (int)1e9;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < arr[i][2]; j++) {
                int busTime = arr[i][0] + arr[i][1] * j;
                if(T > busTime) continue;
                if(busTime-T >= 0 && answer > busTime-T)
                answer = busTime-T;
            }
        }
        if(answer == (int)1e9) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
}
