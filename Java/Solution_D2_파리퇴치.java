package hwalgo03_서울_07반_서동하;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_D2_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[15][15];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxsum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = 0;
					boolean ispass = true;
					for (int r = i; r < i + M; r++) {
						for (int c = j; c < j + M; c++) {
							if (r < 0 || r >= N || c < 0 || c >= N) {
								ispass = false;
								continue;
							}
							sum += map[r][c];
						}
					}
					if (ispass && sum >= maxsum)
						maxsum = sum;
				}
			}

			sb.append(maxsum).append("\n");
			
			
		}
		System.out.println(sb);
	}

}
