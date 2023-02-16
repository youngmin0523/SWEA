import java.util.*;
import java.io.*;

public class Solution_D3_5215_햄버거다이어트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, limit, taste[], cal[], max;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			taste = new int[N];
			cal = new int[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	static void comb(int current_cal, int current_taste, int cnt) {
		if(cnt == N) {
			if(current_cal <= limit) {
				if(max < current_taste) {
					max = current_taste;
				}
			}
			return;
		}
		comb(current_cal+cal[cnt], current_taste+taste[cnt], cnt+1);
		comb(current_cal, current_taste, cnt+1);
	}
}
