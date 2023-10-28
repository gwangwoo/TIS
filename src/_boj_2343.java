import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_2343 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        long left = 1L;
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
        }
        long right = 10_000_000_000L;
        long answer = 10_000_000_000L;
        while(left <= right) {
            long mid = (left + right) >> 1;
            if(check(mid)) {
                answer = Math.min(answer, mid);
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
    static boolean check(long mid) {
        int cnt = 1;
        int sum = 0;
        for(int i = 0 ; i < N ; i++) {
            sum += arr[i];
            if(sum > mid) {
                cnt++;
                sum = arr[i];
            }

        }
        if(cnt <= M) {
            return true;
        }
        return false;
    }
}
