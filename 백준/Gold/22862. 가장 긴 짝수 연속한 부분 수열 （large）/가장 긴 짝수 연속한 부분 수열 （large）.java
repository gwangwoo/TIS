import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int[] prefixCount;
    static List<Integer> even = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] % 2 == 0) {
                even.add(i + 1);
            }
        }
        if (even.size() == 1) {
            System.out.println(1);
            return;
        }
        prefixCount = new int[N + 1];
        int answer = 0;
        int size = even.size();
        int count = 0;
        int start = 0;
        for (int i = 1; i < size; i++) {
            int diff = even.get(i) - even.get(i - 1) - 1;
            prefixCount[i] = diff;
            count += diff;
            while (count > K) {
                count -= prefixCount[++start];
            }
            answer = Math.max(answer, even.get(i) - even.get(start) - count + 1);
        }
        System.out.println(answer);
    }
}
