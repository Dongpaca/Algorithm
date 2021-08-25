import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS {
	//링크노드로 구현해보자
	static class Node implements Comparable<Node>{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public int compareTo(Node o) {
			return this.vertex - o.vertex;
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		
		
		Node[] node = new Node[N + 1];
		boolean[] isvisited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			node[from] = new Node(to,node[from]);
			node[to] = new Node(from,node[to]);
		}
		DFS(node, isvisited, V);
		System.out.println();
		isvisited = new boolean[N + 1];
		BFS(node, isvisited, V);
		
		
	}
	private static void DFS(Node[] node, boolean[] isvisited, int v) {
		isvisited[v] = true;
		System.out.print(v + " ");
		for(Node tmp = node[v];tmp!=null;tmp = tmp.link) {
			if(isvisited[tmp.vertex] == true) continue;
			DFS(node, isvisited, tmp.vertex);
		}
		
	}
	private static void BFS(Node[] node, boolean[] isvisited, int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		isvisited[v] = true;
		while(!q.isEmpty()) {
			int current = q.poll();
			System.out.print(current + " ");
			
			for(Node tmp = node[current];tmp!=null;tmp = tmp.link) {
				if(isvisited[tmp.vertex] == true) continue;
				isvisited[tmp.vertex] = true;
				q.add(tmp.vertex);
			}
		}
	}

}
