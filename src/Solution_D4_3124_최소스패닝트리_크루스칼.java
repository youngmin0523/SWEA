import java.io.*;
import java.util.*;

public class Solution_D4_3124_최소스패닝트리_크루스칼 {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	static List<Edge> edgeList;
	static int V, E;
	static int[] parents, rank;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		edgeList = new ArrayList<>();
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(edgeList);
			makeSet();
			
			long result = 0;
			int cnt = 0;
			for(int i = 0; i < edgeList.size(); i++) {
				if(unionSet(edgeList.get(i).from, edgeList.get(i).to)) {
					result += edgeList.get(i).weight;
					cnt++;
				}
				if(cnt == V-1) {
					break;
				}
			}
			edgeList.clear();
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void makeSet() {
		parents = new int[V+1];
		rank = new int[V+1];
		for(int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}
	static boolean unionSet(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) {
			return false;
		}
		if(rank[rootA] > rank[rootB]) {
			parents[rootB] = rootA;
		}
		else if(rank[rootA] < rank[rootB]) {
			parents[rootA] = rootB;
		}
		else {
			parents[rootB] = rootA;
			rank[rootA]++;
		}
		return true;
	}
}
