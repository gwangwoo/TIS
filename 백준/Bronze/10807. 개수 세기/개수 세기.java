import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int VAL = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[VAL * 2 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            int val = Integer.parseInt(st.nextToken()) + VAL;
            arr[val]++;
        }
        int idx = Integer.parseInt(br.readLine()) + VAL;
        System.out.println(arr[idx]);
    }
}