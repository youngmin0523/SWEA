import java.io.*;
import java.util.*;

public class Solution_D4_3124_최소스패닝트리_크루스칼 {
	static class Edge implements Comparable<Edge>{
		int A, B, C;

		public Edge(int a, int b, int c) {
			super();
			A = a;
			B = b;
			C = c;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.C, o.C);
		}
	}
	
	static List<Edge> edges;
//	static Queue<Edge> edges;
	static int V, E, from, to, weight;
	static int[] unionSet;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edges = new ArrayList<>();
//			edges = new PriorityQueue<>();
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				edges.add(new Edge(from, to, weight));
			}
			Collections.sort(edges);
			
			make();
			Edge edge;
			int cnt = 0;
			long res = 0;
			for(int i = 0; i < E; i++) {
//				edge = edges.poll();
				edge = edges.get(i);
				if(union(edge.A, edge.B)) {
					cnt++;
					res += edge.C;
				}
				if(cnt == V-1) break;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
	static void make() {
		unionSet = new int[V+1];
		for(int i = 1; i < V+1; i++) {
			unionSet[i] = i;
		}
	}
	static int find(int a) {
		if(unionSet[a] == a) return a;
		return unionSet[a] = find(unionSet[a]);
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		unionSet[rootB] = rootA;
		return true;
	}
}
