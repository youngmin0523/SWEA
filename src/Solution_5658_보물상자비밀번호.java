import java.util.*;
import java.io.*;

public class Solution_5658_보물상자비밀번호 {

	static int N, K;
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			list = new ArrayList<>();
			
			for(int i = 0; i < N/4; i++) {
				String tmp = "";
				tmp = tmp.concat(str.substring(str.length()-i, str.length()));
				tmp = tmp.concat(str.substring(0, str.length()-i));
				solve(tmp);
			}
			Collections.sort(list, Collections.reverseOrder());
			
			sb.append('#').append(tc).append(' ').append(list.get(K-1)).append('\n');
		}
		System.out.print(sb.toString());
	}
	static void solve(String str) {
		String tmp;
		for(int i = 0; i < 4; i++) {
			tmp = str.substring(i*N/4, (i+1)*N/4);
			int x = Integer.parseInt(tmp, 16);
			if(!list.contains(x)) {
				list.add(x);
			}
		}
	}
}
