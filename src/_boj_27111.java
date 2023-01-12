import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _boj_27111 {
    static int N;

    public static void main(String[] args) throws IOException {
        Map<Integer, Boolean> map = new TreeMap<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!map.containsKey(a) && b == 1) {
                map.put(a, true);
                continue;
            }
            if(b == 0 && map.containsKey(a)) {
                map.remove(a);
                continue;
            }
            answer++;
        }
        bw.write(answer + map.size()+"\n");
        bw.flush();
        bw.close();
    }
}
