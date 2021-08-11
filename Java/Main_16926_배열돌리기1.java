import java.io.*;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static int N, M, R;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			rotate();
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void rotate() {
		int r = N;
		int c = M;
		int si = 1, sj = 1;
		while (r > 1 && c > 1) {
			anticlockRotate(si, sj, r, c);

			r-=2;
			c-=2;
			si++;
			sj++;
		}

	}

	private static void anticlockRotate(int sx, int sy, int r, int c) {
		// left
		int tmp11 = map[sx][sy];
		for (int j = sy; j < sy + c - 1; j++) {
			map[sx][j] = map[sx][j + 1];
		}
		// up
		for (int i = sx; i < sx + r - 1; i++) {
			map[i][sy + c - 1] = map[i + 1][sy + c - 1];
		}
		// right
		for (int j = sy + c - 1; j >= sy + 1; j--) {
			map[sx + r - 1][j] = map[sx + r - 1][j-1];
		}
		//down
		for(int i = sx + r - 1;i>=sx+1;i--) {
			map[i][sy] = map[i-1][sy];
		}
		map[sx + 1][sy] = tmp11;
	}

}
