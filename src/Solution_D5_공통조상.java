import java.util.*;
import java.io.*;


public class Solution_D5_공통조상 {
	static Node[] tree;
	static int commonAncestor;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int V, E, n1, n2, parent, child;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			tree = new Node[V+1];
			visited = new boolean[V+1];
			commonAncestor = 1;
			
			for(int i = 1; i <= V; i++)
				tree[i] = new Node(i, 0, 0, 0);
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				parent = Integer.parseInt(st.nextToken());
				child = Integer.parseInt(st.nextToken());
				if(tree[parent].lchild == 0) tree[parent].lchild = child;
				else tree[parent].rchild = child;
				tree[child].parent = parent;
			}
			
			while(true) {
				if(n1 == 1 && n2 == 1) break;
				
				if(n1 != 1) {
					n1 = tree[n1].parent;
					if(visited[n1]) {
						commonAncestor = n1;
						break;
					}
					visited[n1] = true;
				}
				
				if(n2 != 1) {
					n2 = tree[n2].parent;
					if(visited[n2]) {
						commonAncestor = n2;
						break;
					}
					visited[n2] = true;
				}
			}
			System.out.println("#" + test_case + " " + commonAncestor + " " + getCount(tree[commonAncestor]));
		}
	}
	
	static int getCount(Node root) {
		int cnt = 0;
		if(root != null)
			cnt = 1 + getCount(tree[root.lchild]) +
					getCount(tree[root.rchild]);
		return cnt;
	}
	
	static class Node {
		int value, parent, lchild, rchild;
		Node(int value, int parent, int lchild, int rchild){
			this.value = value; this.parent = parent; this.lchild = lchild; this.rchild = rchild;
		}
	}
}


