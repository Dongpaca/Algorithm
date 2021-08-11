import java.io.*;
import java.util.*;

public class Main_2564_경비원 {
	static int R, C;
	static int[][] map;
	static boolean[][] isvisited;
	static int sumofdistance = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];
		isvisited = new boolean[R + 1][C + 1];

		int N = Integer.parseInt(in.readLine());

		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				map[i][j] = -1;
			}
		}

		while (N-- > 0) {
			StringTokenizer pit = new StringTokenizer(in.readLine(), " ");
			int z = Integer.parseInt(pit.nextToken());
			int r = 0, c = 0;
			int dis = Integer.parseInt(pit.nextToken());
			if (z == 1) {
				r = 0;
				c = dis;
			} else if (z == 2) {
				r = R;
				c = dis;
			} else if (z == 3) {
				c = 0;
				r = dis;
			} else if (z == 4) {
				c = C;
				r = dis;
			}

			map[r][c] = 1;// 상점
		}
		st = new StringTokenizer(in.readLine(), " ");
		int z = Integer.parseInt(st.nextToken());
		int sr = 0, sc = 0;
		int dis = Integer.parseInt(st.nextToken());
		if (z == 1) {
			sr = 0;
			sc = dis;
		} else if (z == 2) {
			sr = R;
			sc = dis;
		} else if (z == 3) {
			sc = 0;
			sr = dis;
		} else if (z == 4) {
			sc = C;
			sr = dis;
		}
		bfs(sr, sc);

		System.out.println(sumofdistance);
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { sr, sc, 0 });
		isvisited[sr][sc] = true;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int d = q.peek()[2];
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx > R || ny < 0 || ny > C)
					continue;
				if (map[nx][ny] == -1)
					continue;
				if (isvisited[nx][ny] == true)
					continue;
				isvisited[nx][ny] = true;
				q.add(new int[] { nx, ny, d + 1 });
				if (map[nx][ny] == 1)
					sumofdistance += d + 1;
			}

		}
	}

}
