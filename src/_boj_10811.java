import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_10811 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++) arr[i] = i+1;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;
            reverse(left,right);
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
    }
    static void reverse(int a,int b) {
        int[] copyArr = Arrays.copyOfRange(arr, a, b+1);
        int size = copyArr.length;
        for(int i = a ; i <= b ; i++) {
            arr[i] = copyArr[--size];
        }
    }
}
