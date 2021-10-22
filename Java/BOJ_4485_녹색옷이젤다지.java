import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷이젤다지 {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 0;
		while(true) {
			T++;
			int N = Integer.parseInt(in.readLine());
			if(N == 0)
				break;
			int [][]map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int [][]minEdge = new int[N][N];
			for(int i=0;i<N;i++)
				Arrays.fill(minEdge[i],Integer.MAX_VALUE);
			minEdge[0][0] = map[0][0];
			boolean [][] check = new boolean[N][N];
			int result = 0;
			for(int c = 0; c < N*N; c++) {
				int currentx = -1;
				int currenty = -1;
				int min = Integer.MAX_VALUE;
				
				for(int i=0;i<N;i++) {
					for(int j = 0;j<N;j++) {
						if(check[i][j]) continue;
						if(minEdge[i][j] < min) {
							min = minEdge[i][j];
							currentx = i;
							currenty = j;
						}
					}
				}
				result += min;
				check[currentx][currenty] = true;
				if(currentx == N-1 &&currenty == N-1)
					break;
				
				for(int d= 0;d < 4;d++) {
					int nx = currentx + dx[d];
					int ny = currenty + dy[d];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if( !check[nx][ny] && minEdge[nx][ny] > map[nx][ny] + min) {
						minEdge[nx][ny] = map[nx][ny]+ min;
					}
				}
				
			}
			
			System.out.println("Problem " + T + ": " +  minEdge[N-1][N-1]);
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(minEdge[i][j] + " ");
//				}
//				System.out.println();
//			}
			
		}
	}

}
