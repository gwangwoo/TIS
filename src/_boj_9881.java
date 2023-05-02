import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _boj_9881 {
    static int N;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
        }
        Arrays.sort(arr);
        int copyArr[] = Arrays.copyOf(arr, arr.length);
        while(true) {
            if(!check(copyArr)) break;
            copyArr[0]++;
            if(!check(copyArr)) break;
            copyArr[arr.length-1]--;

//            for(int i = 0 ; i < N ; i++) {
//                System.out.print(copyArr[i] + " ");
//            }
//            System.out.println();
        }
        int answer = 0;
        for(int i = 0 ; i < N ; i++) {
            answer += Math.pow(Math.abs(arr[i] - copyArr[i]) , 2);
        }
        System.out.println(answer);



    }
    static boolean check(int[] arr) {
        Arrays.sort(arr);
        if(arr[N-1] - arr[0] <= 17) return false;
        return true;
    }
}
