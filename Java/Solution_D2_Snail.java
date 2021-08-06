

import java.io.*;

public class Solution_D2_Snail {
//	static String str = "10\r\n" + 
//			"1\r\n" + 
//			"2\r\n" + 
//			"3\r\n" + 
//			"4\r\n" + 
//			"5\r\n" + 
//			"6\r\n" + 
//			"7\r\n" + 
//			"8\r\n" + 
//			"9\r\n" + 
//			"10";
	static int []dx = {0,1,0,-1};
	static int []dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc =1;tc<=T;tc++) {
			sb.append("#").append(tc).append("\n");
			int n = Integer.parseInt(in.readLine());
			int [][]map = new int[n][n];
			int movecnt = n; // 움직일 횟수
			int curcnt = 1;//커브 카운트
			int num = 1;
			int sx = 0,sy = -1; // 오른쪽으로 진입하니까
			int direction = 0;
			while(num <= n*n) {
				for(int k = 0;k<movecnt;k++) {
					sx +=dx[direction];
					sy +=dy[direction];
					map[sx][sy] = num;
					num++;
				}
				direction = (direction + 1) % 4;
				curcnt++;
				if(curcnt == 2) {
					curcnt = 0;
					movecnt--;
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
