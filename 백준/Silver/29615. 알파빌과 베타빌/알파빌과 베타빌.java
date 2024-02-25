import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N,M;
    static int[] arr;
    static Set<Integer> friendSet = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) {
            friendSet.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        for(int i = 0 ; i < M ; i++) {
            if(!friendSet.contains(arr[i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
