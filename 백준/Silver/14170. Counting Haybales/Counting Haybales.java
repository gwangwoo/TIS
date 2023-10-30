import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,Q;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
        }
        Arrays.parallelSort(arr);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int left = lower_bound(a);
            int right = upper_bound(b);
            if(left == -1) {
                bw.write("0\n");
            }else {
                bw.write(right-left+1+"\n");
            }

        }
        bw.flush();
        bw.close();
    }

    private static int upper_bound(int target) {
        int left = 0;
        int right = N-1;
        int answer = -1;
        while(left <= right) {
            int mid = (left+right) >> 1;
            if(arr[mid] <= target) {
                left = mid+1;
                answer = mid;
            }else {
                right = mid-1;
            }
        }
        return answer;
    }

    private static int lower_bound(int target) {
        int left = 0;
        int right = N-1;
        int answer = -1;
        while(left <= right) {
            int mid = (left+right) >> 1;
            if(arr[mid] >= target) {
                right = mid-1;
                answer = mid;
            }else {
                left = mid+1;
            }
        }
        return answer;
    }


}
