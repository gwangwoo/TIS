import java.util.*;

public class Main {
	static int N;
	static final int MAX = 1000000;
	static Queue<Long> q = new LinkedList<>();
	static long arr[] = new long[MAX+1];
	static int idx = 9;
	static void preCal() {
		while(idx <= N) {
			if(q.isEmpty()) return;
			long num = q.poll();
			long last = num % 10l;
			for(int i = 0 ; i < last ; i++) {
				q.add(num * 10 + i);
				arr[++idx] = num * 10 + i;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i = 1 ; i <= 9 ; i++) {
			q.add((long)i);
			arr[i] = i;
		}
		preCal();
		if(N != 0 && arr[N] == 0) {
			System.out.println(-1);
		}else System.out.println(arr[N]);
	}

}
