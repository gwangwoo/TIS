import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _boj_2002 {
    static int N;
    static Map<String, Integer> map = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            map.put(str, i+1);
        }
        int answer = 0;
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            int idx = map.get(str);
            visited[idx] = true;
            for(int j = 1 ; j < idx ; j++) {
                if(!visited[j]) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
