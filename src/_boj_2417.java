import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _boj_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long val = Long.parseLong(br.readLine());
        System.out.println(binarySearch(val));
    }

    private static long binarySearch(long val) {
        long left = 0;
        long right = val;
        long answer = right;
        while(left <= right) {
            long mid = (left + right) >> 1;
            if(Math.pow(mid,2) >= val) {
                answer = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return answer;
    }
}
