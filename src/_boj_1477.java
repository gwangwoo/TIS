import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _boj_1477 {
    static int N, M, L;
    static List<Integer> arl = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arl.add(0);
        for (int i = 1; i <= N; i++) {
            arl.add(Integer.parseInt(st.nextToken()));
        }
        arl.add(L);
        Collections.sort(arl);
        int left = 1;
        int right = L - 1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 1; i < arl.size(); i++) {
                int diff = arl.get(i) - arl.get(i - 1);
                int restCount = diff / mid;
                count += diff % mid != 0 ? restCount : restCount - 1;
            }
            if(count > M) {
                left = mid+1;
            }else {
                answer = mid;
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
