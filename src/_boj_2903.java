import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _boj_2903 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[16];
        arr[0] = 2;
        for(int i = 1 ; i <= 15 ; i++) {
            arr[i] = arr[i-1] * 2 - 1;
        }
        System.out.println((int)Math.pow(arr[N], 2));
    }
}
