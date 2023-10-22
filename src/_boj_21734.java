import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _boj_21734 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i = 0 ; i < str.length() ; i++) {
            String num = (int) str.charAt(i)+"";
            int cnt = 0;
            for(int j = 0 ; j < num.length(); j++) {
                cnt += num.charAt(j)-'0';
            }
            for(int j = 0 ; j < cnt ; j++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }
}
