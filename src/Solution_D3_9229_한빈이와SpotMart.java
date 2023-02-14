import java.util.*;
import java.io.*;


public class Solution_D3_9229_한빈이와SpotMart {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int TC, N, M, weight[], res;
	
	public static void main(String[] args) throws Exception {
		TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			weight = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weight);
			res = -1;
			comb(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	static void comb(int cnt, int start, int tmp) {
		if(cnt == 2) {
			if(tmp > res) {
				res = tmp;
			}
			return;
		}
		for(int i = start; i < N; i++) {
			if(tmp+weight[i] > M) {
				return;
			}
			comb(cnt+1, i+1, tmp+weight[i]);
		}
	}
}
