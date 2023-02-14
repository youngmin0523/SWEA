import java.io.*;
import java.util.*;


public class Solution_D3_1225_암호생성기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Integer> deque;
	static int tmp, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		for (int tc = 1; tc <= 10; tc++) {
			boolean flag = false;
			deque = new ArrayDeque<>();
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[8];
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 8; i++) {
				int tmp = arr[i] / 15;
				if (min > tmp)
					min = tmp;
			}
			for (int i = 0; i < 8; i++) {
				arr[i] %= 15 * (min - 1);
			}
			for (int i = 0; i < 8; i++) {
				deque.offer(arr[i]);
			}
			while (!flag) {
				for (int i = 1; i <= 5; i++) {
					tmp = deque.poll() - i;
					if (tmp <= 0) {
						deque.offer(0);
						flag = true;
						break;
					}
					deque.offer(tmp);
				}
			}
			sb.append("#").append(tc);
			while (!deque.isEmpty()) {
				sb.append(" ").append(deque.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}