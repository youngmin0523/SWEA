import java.util.*;
import java.io.*;


public class Solution_D5_최적경로 {
	static boolean[] visited;
	static Node[] customer;
	static int N, min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			customer = new Node[N+2];
			visited = new boolean[N+1];
			customer[0] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customer[N+1] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i = 1; i < N + 1; i++)
				customer[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			tsp(0, customer[0], 0);
			
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	static void tsp(int K, Node node, int tmp) {
		if(K == N) {
			tmp += getDistance(node, customer[N+1]);
			if(tmp < min) min = tmp;
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tsp(K+1, customer[i], tmp + getDistance(node, customer[i]));
				visited[i] = false;
			}
		}
	}
	
	static int getDistance(Node node1, Node node2) {
		return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
	}
	
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x; this.y = y;
		}
	}
}


