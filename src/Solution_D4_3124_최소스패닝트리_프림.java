import java.io.*;
import java.util.*;

public class Solution_D4_3124_최소스패닝트리_프림 {
	static class Node implements Comparable<Node> {
		int no, weiht;

		public Node(int no, int weiht) {
			this.no = no;
			this.weiht = weiht;
		}

		@Override
		public int compareTo(Node o) {
			return this.weiht-o.weiht;
		}
		
	}
	
	static int V,E, from, to, weight;
	static List<Node> adjList[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				adjList[from].add(new Node(to, weight));
				adjList[to].add(new Node(from, weight));
			}
			
			sb.append("#").append(tc).append(" ").append(prim()).append("\n");
		}
		System.out.print(sb.toString());
	}
	static long prim() {
		boolean[] visited = new boolean[V+1];
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		
		long res = 0;
		int cnt = 0;
		Node current = null;
		while(!pq.isEmpty()) {
			current = pq.poll();
			if(visited[current.no]) continue;
			visited[current.no] = true;
			res += current.weiht;
			if(++cnt == V) break;
			
			for(Node node : adjList[current.no]) {
				if(!visited[node.no]) {
					pq.offer(node);
				}
			}
		}
		return res;
	}
}
