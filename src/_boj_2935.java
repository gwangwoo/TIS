import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _boj_2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String op = br.readLine();
        String b = br.readLine();

        if(a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        if(op.equals("*")) {
            int zeroCnt = b.length()-1;
            while(zeroCnt-- > 0) a += "0";
        }
        else {
            int idx = a.length() - b.length();
            if(a.charAt(idx) == '0') {
                a = a.substring(0, idx) + "1" + a.substring(idx+1);
            }else {
                a = a.substring(0, idx) + "2" + a.substring(idx+1);
            }
        }
        System.out.println(a);
    }
}
