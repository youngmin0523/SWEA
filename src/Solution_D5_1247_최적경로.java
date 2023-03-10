import java.util.*;
import java.io.*;

public class Solution_D5_1247_최적경로 {
	static class Place{
		int x, y;
		public Place(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N, res, matrix[][];
	static Place[] places;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			matrix = new int[N+2][N+2];
			places = new Place[N+2];
			res = Integer.MAX_VALUE;
			isSelected = new boolean[N+1];
			places[0] = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			places[N+1] = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i = 1; i <= N; i++) {
				places[i] = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			get_matrix();
			dfs(0, 0 ,0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int cnt, int current, int distance) {
		if(cnt == N) {
			distance += matrix[current][N+1];
			if(distance < res) {
				res = distance;
			}
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			int tmp = distance + matrix[current][i];
			if(tmp < res) {
				dfs(cnt+1, i, tmp);
			}
			isSelected[i] = false;
		}
	}
	static int get_distance(Place A, Place B) {
		 return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
	}
	static void get_matrix() {
		int tmp;
		for(int i = 0; i < N+2; i++) {
			for(int j = i; j < N+2; j++) {
				if(i == j) continue;
				tmp = get_distance(places[i], places[j]);
				matrix[i][j] = tmp;
				matrix[j][i] = tmp;
			}
		}
	}
}
