import java.io.*;
import java.util.StringTokenizer;

public class Solution_D3_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[50][50];
			char[] tmp = new char[50];
			
			for(int i=0;i<N;i++) {
				tmp = in.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					map[i][j] = tmp[j] - '0';
				}
			}
			int sum = 0;
			int y;
			for (int i = 0; i < N/2; i++) {
				y = 0;
				for(int k = N/2 - i; k>0;k--) //점프!
					y++;
				for(int z = 0; z < (i*2) + 1; z++) {//농작물 수확!
					sum+=map[i][y];
					map[i][y] = 9;
					y++;
				}
			}
			for(int i = N/2; i<N;i++) {
				y=0;
				for(int k = 0;k< i - N/2;k++)
					y++;
				for(int z = 2 *(N/2 - (i - N/2)) + 1;z>0;z--) {
					sum+=map[i][y];
					map[i][y] = 9;
					y++;
				}
			}
			
//			
//			for(int i=0;i<N;i++) {
//				for(int j = 0;j<N;j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			sb.append(sum);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
