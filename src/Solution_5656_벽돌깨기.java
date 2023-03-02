import java.util.*;
import java.io.*;

public class Solution_5656_벽돌깨기 {
	static class Pos {
		int r, c, length;

		public Pos(int r, int c, int length) {
			super();
			this.r = r;
			this.c = c;
			this.length = length;
		}
	}
	
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
			
			sb.append('#').append(tc).append(' ').append(rockCnt-res).append('\n');
		}
		System.out.println(sb.toString());
	}
	static void solve(int[] selected) {
		int[][] copyMap = new int[H][W];
		for(int i = 0; i < H; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, W);
		}
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int c = selected[i];
			for(int j = 0; j < H; j++) {
				if(copyMap[j][c] != 0) {
					cnt = eleminate(copyMap, j, c, cnt);
					break;
				}
			}
		}
		if(cnt > res) {
			res = cnt;
		}
	}
	static int eleminate(int[][] copyMap, int r, int c, int cnt) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(r, c, copyMap[r][c]));
		
		Pos current;
		while(!q.isEmpty()) {
			current = q.poll();
			r = current.r;
			c = current.c;
			
			// 본인
			if(copyMap[r][current.c] != 0) {
				cnt++;
				copyMap[r][current.c] = 0;
			}
			
			for(int i = 1; i < current.length; i++) {
				// 위방향
				if(range(r-i, c)) {
					q.offer(new Pos(r-i, c, copyMap[r-i][c]));
					if(copyMap[r-i][c] != 0) {
						cnt++;
						copyMap[r-i][c] = 0;
					}
				}
				// 아래방향
				if(range(r+i, c)) {
					q.offer(new Pos(r+i, c, copyMap[r+i][c]));
					if(copyMap[r+i][c] != 0) {
						cnt++;
						copyMap[r+i][c] = 0;
					}
				}
				// 오른쪽방향
				if(range(r, c+i)) {
					q.offer(new Pos(r, c+i, copyMap[r][c+i]));
					if(copyMap[r][c+i] != 0) {
						cnt++;
						copyMap[r][c+i] = 0;
					}
				}
				// 왼쪽방향
				if(range(r, c-i)) {
					q.offer(new Pos(r, c-i, copyMap[r][c-i]));
					if(copyMap[r][c-i] != 0) {
						cnt++;
						copyMap[r][c-i] = 0;
					}
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < W; i++) {
			for(int j = H-1; j >= 0; j--) {
				if(copyMap[j][i] != 0) {
					list.add(copyMap[j][i]);
					copyMap[j][i] = 0;
				}
			}
			int index = H-1;
			for(int tmp : list) {
				copyMap[index--][i] = tmp;
			}
			list.clear();
		}
		return cnt;
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
