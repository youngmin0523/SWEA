import java.util.*;
import java.io.*;

public class Solution_D4_보급로 {
	static int[][] move = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	static int road[][], cost[][], N, dx, dy;
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= C; test_case++) {
			N = Integer.parseInt(br.readLine());
			road = new int[N][N]; cost = new int[N][N]; visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for(int j = 0; j < N; j++)
					road[i][j] = tmp[j] - '0';
			}
			bfs();
			System.out.println("#" + test_case + " " + cost[N-1][N-1]);
		}
	}
	
	static void bfs() {
		Queue<Position> q = new LinkedList<>();
		Position pos;
		int nx, ny;
		visited[0][0] = true; cost[0][0] = 0;
		q.add(new Position(0, 0));
		
		while(!q.isEmpty()) {
			pos = q.poll();
			
			for(int i = 0; i < 4; i++) {
				nx = pos.x + move[i][0];
				ny = pos.y + move[i][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(!visited[nx][ny] || cost[nx][ny] > cost[pos.x][pos.y] + road[nx][ny]) {
						visited[nx][ny] = true;
						cost[nx][ny] = cost[pos.x][pos.y] + road[nx][ny];
						q.add(new Position(nx, ny));
					}
				}
			}
		}
	}
}

class Position {
	int x, y;
	
	Position(int x, int y){
		this.x = x; this.y = y;
	}
}