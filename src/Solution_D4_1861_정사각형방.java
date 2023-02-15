import java.util.*;
import java.io.*;

public class Solution_D4_1861_정사각형방 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, room[][], number, cnt;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			number = N*N; cnt = 0;
			room = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int tmp = getCnt(i, j, 1);
					if(tmp > cnt) {
						cnt = tmp;
						number = room[i][j];
					}
					else if(tmp == cnt) {
						if(number > room[i][j]) {
							number = room[i][j];
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(number);
			sb.append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	static int getCnt(int row, int col, int cnt) {
		int tmp = cnt;
		
		for(int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(!range(nr, nc)) continue;
			if(room[nr][nc] == room[row][col]+1) {
				tmp = getCnt(nr, nc, cnt+1);
			}
		}
		return tmp;
	}
	static boolean range(int i, int j) {
		if(i >= 0 && i< N && j >= 0 && j < N) {
			return true;
		}
		return false;
	}
}
