import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D4_창용마을무리의개수 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T= Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean[][] Matrix = new boolean[N][N];
			int parent[]  = new int[N];
			make(parent, N);
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				union(parent,N,a,b);
			}
			boolean check[] = new boolean[N];
			int cnt = 0;
			for(int i = 0;i<N;i++) {
				int root = find(parent,i);
				if(check[root] == false) {
					cnt++;
					check[root] = true;
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
		
	}

	private static boolean union(int[] parent, int N, int a, int b) {
		int aRoot = find(parent,a);
		int bRoot = find(parent,b);
		if(aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}

	private static int find(int[] parent, int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent,parent[x]);
	}

	private static void make(int[] parent, int N) {
		for(int i=0;i<N;i++) {
			parent[i] = i;
		}
	}

}
