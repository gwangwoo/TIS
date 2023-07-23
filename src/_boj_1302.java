import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class _boj_1302 {
    static int N;
    static Map<String,Integer> map = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int max = 0;
        while(N-- > 0) {
            String str = br.readLine();
            if(!map.containsKey(str)) {
                map.put(str,1);
                max = Math.max(max,1);
            } else {
                int cnt = map.get(str);
                map.put(str, ++cnt);
                max = Math.max(cnt, max);
            }
        }
        String answer = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                System.out.println(entry.getKey());
                return;
            }
        }
    }
}
