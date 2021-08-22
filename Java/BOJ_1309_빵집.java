import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1309_빵집 {
	static int R, C;
	static char[][] map;
	static boolean isSuccess;
	static int SuccessCnt;
	static int[] dx = { -1, 0, 1};
	static int[] dy = {  1, 1, 1};
	static boolean[] isvisitedBread;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isvisitedBread = new boolean[R];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
			//map[i][0] = (char) (i + 1 + '0');
			map[i][0] = '$';
		}
			
		SuccessCnt = 0;
		go();
		//print();
		System.out.println(SuccessCnt);
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void go() {
		for (int i = 0; i < R; i++) {
			isSuccess = false;
			//map[i][0] = (char) (i + 1 + '0');
			dfs(i, 0, (char) (i + 1 + '0'));
		}

	}

	private static void dfs(int x, int y, char Num) {
		if (y == C - 1) {// 끝까지 갔다면
			if (isvisitedBread[x] == false) {// 끝까지 갔는데 빵집도 처음이라면 성공
				isSuccess = true;
				isvisitedBread[x] = true;
				SuccessCnt++;
			}
			return;
		}
		for (int dir = 0; dir < 3; dir++) {
			if (isSuccess == true)
				break;// 성공했다면 더이상 할 필요가 없어!
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			if (map[nx][ny] != '.')
				continue;
			map[nx][ny] = '$';
			dfs(nx, ny, Num);
			if (isSuccess == true)
				break;// 성공했다면 더이상 할 필요가 없어!
		}
	}

}
