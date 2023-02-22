import java.util.*;
import java.io.*;

public class Solution_D3_1873_상호의배틀필드 {
	static class Tank{
		int r, c;
		char dir;
		public Tank(int r, int c, char dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static int H, W, N;
	static char[][] map;
	static String str;
	static Tank tank;
	static char command;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				str = br.readLine();
				for(int j = 0; j < W;j ++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || 
							map[i][j] == '^' || map[i][j] == 'v') {
						tank = new Tank(i, j, map[i][j]);
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			str = br.readLine();
			for(int i = 0; i < N; i++) {
				command = str.charAt(i);
				exe();
			}
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	static void exe() {
		switch(command) {
		case 'U':
			tank.dir = '^';
			if(range(tank.r-1, tank.c) && map[tank.r-1][tank.c] == '.') {
				map[tank.r-1][tank.c] = tank.dir;
				map[tank.r][tank.c] = '.';
				tank.r = tank.r-1;
				return;
			}
			map[tank.r][tank.c] = tank.dir;
			break;
		case 'D':
			tank.dir = 'v';
			if(range(tank.r+1, tank.c) && map[tank.r+1][tank.c] == '.') {
				map[tank.r+1][tank.c] = tank.dir;
				map[tank.r][tank.c] = '.';
				tank.r = tank.r+1;
				return;
			}
			map[tank.r][tank.c] = tank.dir;
			break;
		case 'L':
			tank.dir = '<';
			if(range(tank.r, tank.c-1) && map[tank.r][tank.c-1] == '.') {
				map[tank.r][tank.c-1] = tank.dir;
				map[tank.r][tank.c] = '.';
				tank.c = tank.c-1;
				return;
			}
			map[tank.r][tank.c] = tank.dir;
			break;
		case 'R':
			tank.dir = '>';
			if(range(tank.r, tank.c+1) && map[tank.r][tank.c+1] == '.') {
				map[tank.r][tank.c+1] = tank.dir;
				map[tank.r][tank.c] = '.';
				tank.c = tank.c+1;
				return;
			}
			map[tank.r][tank.c] = tank.dir;
			break;
		case 'S':
			switch(tank.dir) {
			case '<':
				for(int i = tank.c-1; i >= 0; i--) {
					if(map[tank.r][i] == '*') {
						map[tank.r][i] = '.';
						return;
					}
					else if(map[tank.r][i] == '#') {
						return;
					}
				}
				break;
			case '>':
				for(int i = tank.c+1; i < W; i++) {
					if(map[tank.r][i] == '*') {
						map[tank.r][i] = '.';
						return;
					}
					else if(map[tank.r][i] == '#') {
						return;
					}
				}
				break;
			case '^':
				for(int i = tank.r-1; i >= 0; i--) {
					if(map[i][tank.c] == '*') {
						map[i][tank.c] = '.';
						return;
					}
					else if(map[i][tank.c] == '#') {
						return;
					}
				}
				break;
			case 'v':
				for(int i = tank.r+1; i < H; i++) {
					if(map[i][tank.c] == '*') {
						map[i][tank.c] = '.';
						return;
					}
					else if(map[i][tank.c] == '#') {
						return;
					}
				}
			}
		}
	}
	static boolean range(int r, int c) {
		if(r < 0 || r >= H || c < 0 || c >= W) return false;
		return true;
	}
}
