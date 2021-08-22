import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C;
	static char map[][];
	static int maxcnt = 1;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean isvisited[][];
	static boolean alpha[] = new boolean [26];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isvisited = new boolean[R][C];
		for (int i = 0; i < R; i++)
			map[i] = in.readLine().toCharArray();
		alpha[map[0][0] - 'A'] = true;
		isvisited[0][0] = true;
		System.out.println(go(0, 0));
	}

	private static int go(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i]; int ny = y + dy[i];
			if(nx<0 || nx >= R || ny < 0 || ny >= C) continue;
			if(isvisited[nx][ny] == true) continue;
			if(alpha[map[nx][ny] - 'A'] == true) continue;
			isvisited[nx][ny] = true;
			alpha[map[nx][ny] - 'A'] = true;
			int ncnt = go(nx,ny);
			if(ncnt > cnt )
				cnt=ncnt;
			isvisited[nx][ny] = false;
			alpha[map[nx][ny] - 'A'] = false;
		}
		return cnt + 1;
	}

}
