import java.io.*;
import java.util.*;

public class Main_17406_배열돌리기4 {
	static int N, M, K;
	static int[][] map;
	static int si,sj,s;
	static boolean[] isselected;
	static List<int[]> orderidx = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		int [][]originMap = new int[N+1][M+1];
		isselected = new boolean[K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				originMap[i][j] = map[i][j];
			}
		}
		List<int[]> orderlist = new LinkedList<int[]>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			si = Integer.parseInt(st.nextToken());
			sj = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			si -= s;sj-=s;
			orderlist.add(new int[] {si,sj,s});
			
		}
		int[] pos = new int[K + 1];
		permutation(1,pos, 0);
		
		int result = Integer.MAX_VALUE;
		for(int i = 0;i<orderidx.size();i++) {
			
			for(int j = 1;j<=K;j++) {
				int a = orderidx.get(i)[j] - 1;
				rotate(orderlist.get(a)[0],orderlist.get(a)[1],orderlist.get(a)[2]);
				/*for(int c = 1;c<=N;c++) {
					for(int v=1;v<=M;v++) {
						System.out.print(map[c][v] + " ");
					}
					System.out.println();
				}
				System.out.println("*****");*/
			}
			
			int tmp = findmin();
			if(tmp < result)
				result = tmp;
			for(int c = 1;c<=N;c++) {
				for(int v=1;v<=M;v++) {
					map[c][v] = originMap[c][v];
				}
			}
			
		}
			
		
		sb.append(result);
		System.out.println(sb.toString());
	}
	private static void permutation(int idx, int[] pos,int cnt) {
		if(idx > K && cnt == K) {
			int[]tmp = new int[K + 1];
			for(int i=1;i<=K;i++)
				tmp[i] = pos[i];
			orderidx.add(tmp);
			return;
		}
		
		for(int i=1;i<=K;i++) {
			if(isselected[i] == false) {
				isselected[i] = true;
				pos[idx] = i;
				permutation(idx + 1,pos,cnt+1);
				isselected[i] = false;
			}
		}
	}
	private static int findmin() {
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			int sum = 0;
			for(int j=1;j<=M;j++) {
				sum+=map[i][j];
			}
			if(sum < min)
				min = sum;
		}
		return min;
	}
	private static void rotate(int sx, int sy, int ss) {
		int r = ss*2 + 1;
		int c = ss * 2 + 1;
		
		while (r > 1 && c > 1) {
			clockRotate(sx, sy, r, c);
			r-=2;
			c-=2;
			sx++;
			sy++;
		}

	}
	private static void clockRotate(int sx, int sy, int r, int c) {
		// left
		int tmp11 = map[sx + r - 1][sy];
		for (int j = sy; j < sy + c - 1; j++) {
			map[sx + r - 1][j] = map[sx + r - 1][j + 1];
		}
		//down
			for(int i = sx + r - 1;i>=sx+1;i--) {
				map[i][sy + c - 1] = map[i-1][sy + c - 1];
			}
		// right
		for (int j = sy + c - 1; j >= sy + 1; j--) {
			map[sx][j] = map[sx][j-1];
		}
		// up
		for (int i = sx; i < sx + r - 1; i++) {
			map[i][sy] = map[i + 1][sy];
		}
		
		
		map[sx + r - 2][sy] = tmp11;
	}
}
