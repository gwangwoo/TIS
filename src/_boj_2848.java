import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class _boj_2848 {
    static int N;
    static List<Integer> adj[] = new ArrayList[26];
    static List<String> strs;
    static boolean visited[];
    static int indegree[];
    static List<Integer> order;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strs = new ArrayList<>();
        visited = new boolean[26];
        indegree = new int[26];
        order = new ArrayList<>();
        IntStream.range(0, 26).forEach(i -> adj[i] = new ArrayList<>());
        IntStream.range(0, N).forEachOrdered(idx -> {
            try {
                String str = br.readLine();
                strs.add(str);
                IntStream.range(0, str.length()).forEach(i -> visited[str.charAt(i) - 'a'] = true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        boolean flag = false;
        for (int i = 0; i < N - 1; i++) {
            int j = i + 1;
            int size = Math.min(strs.get(i).length(), strs.get(j).length());
            String first = strs.get(i);
            String last = strs.get(j);
            for (int k = 0; k < size; k++) {
                if (first.charAt(k) != last.charAt(k)) {
                    if (adj[last.charAt(k) - 'a'].contains(first.charAt(k) - 'a')) {
                        flag = true;
                        break;
                    }
                    adj[first.charAt(k) - 'a'].add(last.charAt(k) - 'a');
                    indegree[last.charAt(k) - 'a']++;
                    break;
                }
                if(k == last.length()-1 && first.length() > last.length()) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (flag) {
            System.out.println("!");
            return;
        }
        IntStream.range(0, 26)
                 .filter(idx -> visited[idx])
                 .filter(idx -> indegree[idx] == 0)
                 .forEach(idx -> q.add(idx));
        List<Integer> answer = new ArrayList<>();
        Arrays.fill(visited, false);
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 1) {
                System.out.println("?");
                return;
            }
            while (size-- > 0) {
                int p = q.poll();
                answer.add(p);
                for (int y : adj[p]) {
                    if (visited[y]) {
                        continue;
                    }
                    indegree[y]--;
                    if (indegree[y] == 0) {
                        q.add(y);
                        visited[y] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (indegree[i] != 0) {
                System.out.println("!");
                return;
            }
        }
        answer.stream().forEachOrdered(idx -> System.out.print((char) (idx + 'a')));
    }
}
