import java.io.*;
import java.util.*;

public class Solution_Battle_수열편집 {
	static int N, M, L;
	static List<String> sequence;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sequence = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				sequence.add(st.nextToken());
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				switch(st.nextToken().charAt(0)) {
				case 'I':
					sequence.add(Integer.parseInt(st.nextToken()),
							st.nextToken());
					break;
				case 'D':
					sequence.remove(Integer.parseInt(st.nextToken()));
					break;
				case 'C':
					sequence.set(Integer.parseInt(st.nextToken()), st.nextToken());
				}
			}
			sb.append("#").append(tc).append(" ");
			sb.append(L<sequence.size()?sequence.get(L):-1).append("\n");
		}
		System.out.println(sb);
	}

}
