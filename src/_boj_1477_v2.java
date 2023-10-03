import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_1477_v2 {
    static int N, M, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N + 1] = L;
        Arrays.sort(arr);
        int left = 1;
        int right = L - 1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 1; i < N + 2; i++) {
                int diff = arr[i] - arr[i - 1];
                count += diff % mid == 0 ? diff / mid - 1 : diff / mid;
            }
            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
