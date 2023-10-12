import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _boj_5052 {
    static int T, N;
    static List<String> arl = new ArrayList<>();
    static Set<String> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            hs.clear();
            arl.clear();
            for(int i = 0 ; i < N ; i++) {
                String str = br.readLine();
                arl.add(str);
                hs.add(str);
            }
            boolean flag = false;
            for(int i = 0 ; i < N ; i++) {
                String str = arl.get(i);
                for(int j = 0 ; j < str.length() ; j++) {
                    String target = str.substring(0, j+1);
                    if(target != str && hs.contains(target)) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
            if (flag) {
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }
}
