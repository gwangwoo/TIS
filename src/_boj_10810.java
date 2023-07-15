import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_10810 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;
            int val = Integer.parseInt(st.nextToken());
            for(int i = left ; i <= right ; i++) arr[i] = val;
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x+ " "));
    }
}
