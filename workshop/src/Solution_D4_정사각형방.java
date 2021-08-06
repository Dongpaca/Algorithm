import java.io.*;
import java.util.*;

public class Solution_D4_정사각형방 {
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	static int N;
	static int[][]map = new int[1000][1000];
	static int nowcnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		System.out.println("13123");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			for(int i = 0 ; i<N;i++) {
				StringTokenizer st= new StringTokenizer(in.readLine()," ");
				for(int j= 0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxcnt = -1;
			int maxvalue = 0;
			int rx= 0,ry =0 ;
			
			for(int i = 0 ; i<N;i++) {
				for(int j= 0;j<N;j++) {
					int result = dfs(i,j);
					if(maxcnt == -1 ||maxcnt < result) {
						maxcnt = result;
						maxvalue = map[i][j];
						rx = i; ry = j;
					}else if(maxcnt == result && map[i][j] < maxvalue){
						maxcnt = result;
						maxvalue = map[i][j];
						rx = i; ry = j;
					}
				}
			}
			sb.append(maxvalue).append(" ").append(maxcnt).append("\n");
		}
		System.out.println(sb);
	}
	
	/*1
	2
	2 3 
	1 4  */
	static int dfs(int sx, int sy) {
		for(int i=0;i<4;i++) {
			int nx = sx + dx[i]; int ny = sy + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(map[nx][ny] != map[sx][sy] + 1) continue;
			nowcnt++;
			return dfs(nx,ny);
		}
		int result = nowcnt;
		nowcnt = 1;
		return result;
	}
	
	
}
