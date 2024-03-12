import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.length() < 2 || str.substring(1, str.length()-1).trim().isEmpty() || str.charAt(0) != '"' || str.charAt(str.length()-1) != '"') {
            System.out.println("CE");
            return;
        }
        System.out.println(str.substring(1, str.length()-1));
    }
}
