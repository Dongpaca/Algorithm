import java.io.*;
import java.util.*;

public class BOJ_15683_감시 {
	static int[][] way = { { 0 }, { 0, 2 }, { 0, 1 }, { 0, 1, 2 }, { 0, 1, 2, 3 } };
	static int[][] dxy = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		List<int[]> cctvPos = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					cctvPos.add(new int[] { i, j });
				}
			}
		}
		int[] cctvDirect = new int[cctvPos.size()];
		cctvDirection(map, 0, cctvDirect, cctvPos.size(), cctvPos);
		System.out.println(result);

	}

	private static void cctvDirection(int[][] ori_map, int idx, int[] cctvDirect, int size, List<int[]> cctvPos) {
		if (idx == size) {
			simulation(ori_map, cctvDirect, cctvPos);
			int tmp = calc(ori_map);
			if (result > tmp)
				result = tmp;
			return;
		}

		for (int d = 0; d < 4; d++) {
			cctvDirect[idx] = d;
			cctvDirection(ori_map, idx + 1, cctvDirect, size, cctvPos);
		}
	}

	private static int calc(int[][] ori_map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ori_map[i][j] == 0)
					cnt++;
				else if(ori_map[i][j] =='#')
					ori_map[i][j] =  0;
			}
		}
		return cnt;
	}

	private static void simulation(int[][] map, int[] cctvDirect, List<int[]> cctvPos) {
		for (int c = 0; c < cctvPos.size(); c++) {
			int x = cctvPos.get(c)[0];
			int y = cctvPos.get(c)[1];
			int Direct = cctvDirect[c];
			int cctvType = map[x][y] - 1;

			for (int d = 0; d < way[cctvType].length; d++) {
				int direction = (way[cctvType][d] + Direct) % 4;
				int nx = x + dxy[direction][0];
				int ny = y + dxy[direction][1];
				
				while(true) {
					if(nx < 0 || nx >= N || ny < 0 || ny>= M)break;
					if(map[nx][ny] == 6) break;
					if(map[nx][ny] == 0)
						map[nx][ny] = '#';
					nx += dxy[direction][0];
					ny += dxy[direction][1];
				}
			}

		}
	}

}
