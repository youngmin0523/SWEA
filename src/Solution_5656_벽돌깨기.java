import java.util.*;
import java.io.*;

public class Solution_5656_벽돌깨기 {

	static int N, W, H, rockCnt, res;
	static int[][] map;
	static int[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			res = 0; rockCnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			selected = new int[N];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						rockCnt++;
					}
				}
			}
			perm(0);
			
			sb.append('#').append(tc).append(' ').append(res).append('\n');
		}
		System.out.println(sb.toString());
	}
	static void solve(int[] selected) {
		int cnt = 0;
		int[][] copyMap = new int[H][W];
		for(int i = 0; i < H; i++) {
			copyMap[H] = Arrays.copyOf(map[H], W);
		}
		for(int i = 0; i < N; i++) {
			int c = selected[i];
			for(int j = 0; j < H; j++) {
				if(copyMap[j][c] != 0) {
					int num = copyMap[j][c];
					cnt++;
					copyMap[j][c] = 0;
					for(int tmp = 1; tmp < num; tmp++) {
						if(range(j+tmp, c)) {
							copyMap[j+tmp][c] = 0;
							cnt++;
						}
						
					}
					break;
				}
			}
		}
	}
	static boolean range(int r, int c) {
		if(r >= 0 && r < H && c >= 0 && c < W) return true;
		return false;
	}
	static void perm(int cnt) {
		if(cnt == N) {
			solve(selected);
			return;
		}
		for(int i = 0; i < W; i++) {
			selected[cnt] = i;
			perm(cnt+1);
		}
	}
}
