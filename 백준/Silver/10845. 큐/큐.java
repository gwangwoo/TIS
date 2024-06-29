import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();       // 스택 생성
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    queue.add(X);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(queue.poll() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write("1\n");
                        break;
                    }
                    bw.write("0" + "\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(queue.peekFirst() + "\n");
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(queue.peekLast() + "\n");
                    break;
            }
            bw.flush();
        }
    }
}
