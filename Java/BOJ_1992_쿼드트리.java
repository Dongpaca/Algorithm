import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		int tmpNum = map[0][0];
		boolean ismatch = true;
		for (int i = 0; i <N; i++) {
			for (int j = 0; j <N; j++) {
				if(tmpNum != map[i][j]) {
					ismatch = false;
					break;
				}
			}
		}
		if(ismatch == true)
			System.out.print(tmpNum);
		else
			go(N, 0, 0);

		int a = 0;
	}

	private static void go(int n, int x, int y) {
		System.out.print("(");
		int[] startx = { x, x, x + n / 2, x + n / 2 };
		int[] starty = { y, y + n / 2, y, y + n / 2 };
		for(int k=0;k<4;k++) {
			int tmpNum = map[startx[k]][starty[k]];
			boolean ismatch = true;
			for (int i = startx[k]; i < startx[k] + n / 2; i++) {
				for (int j = starty[k]; j < starty[k] + n / 2; j++) {
					if(tmpNum != map[i][j]) {
						ismatch = false;
						break;
					}
				}
				if(ismatch == false)
					break;
			}
			if(ismatch == true)
				System.out.print(tmpNum);
			else
				go(n/2, startx[k], starty[k]);
		}
		

		System.out.print(")");
	}

}
