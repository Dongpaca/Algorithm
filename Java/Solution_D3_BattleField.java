import java.io.*;
import java.util.StringTokenizer;

public class Solution_D3_BattleField {

	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static char[] chdirec = {'^','v','<','>'};
	static String chMove = "UDLR";

	public static void main(String[] args) throws NumberFormatException, IOException {

//문자	의미
//.	평지(전차가 들어갈 수 있다.)
//*	벽돌로 만들어진 벽
//#	강철로 만들어진 벽
//-	물(전차는 들어갈 수 없다.)
//^	위쪽을 바라보는 전차(아래는 평지이다.)
//v	아래쪽을 바라보는 전차(아래는 평지이다.)
//<	왼쪽을 바라보는 전차(아래는 평지이다.)
//>	오른쪽을 바라보는 전차(아래는 평지이다.)

//문자	동작
//U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			char[][] map = new char[20][20]; // 최대 맵사이즈
			char[] pose = new char[100]; // 행동 최대 사이즈
			StringTokenizer s = new StringTokenizer(in.readLine(), " ");
			int R = Integer.parseInt(s.nextToken());
			int C = Integer.parseInt(s.nextToken());
			int sx = 0, sy = 0, direction = 0; // 시작 탱크위치, 방향
			for (int i = 0; i < R; i++) {
				String tmp = in.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
						if (map[i][j] == '^')
							direction = 0;
						else if (map[i][j] == 'v')
							direction = 1;
						else if (map[i][j] == '<')
							direction = 2;
						else if (map[i][j] == '>')
							direction = 3;
						map[i][j] = '.';
						sx = i;
						sy = j;
					}
				}
			}
//			3 5
//			>-#**
//			.-*#*
//			.-**#
//			15
//			SSSDRSSSDRSSSUU
			int movecnt = Integer.parseInt(in.readLine());
			pose = in.readLine().toCharArray();
			// 입력끝
			for (int k = 0; k < movecnt; k++) {
				int action = chMove.indexOf(pose[k]);
				if (action != -1) { // move일때
					direction = action;
					int nx = sx + dx[direction];
					int ny = sy + dy[direction];
					if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
						sx = nx;
						sy = ny;
					}
				} else {// shooting일때
					int bx = sx, by = sy;
					boolean isCannon = true;//대포 생존여부
					while (true) {
						bx += dx[direction];
						by += dy[direction];
						if (bx < 0 || bx >= R || by < 0 || by >= C) { //대포 맵밖으로
							isCannon = false;
						}else if(map[bx][by] == '*') {//일반 벽
							map[bx][by] = '.';
							isCannon = false;
						}else if(map[bx][by] == '#') {//강철 벽 
							isCannon = false;
						}
						if (!isCannon)
							break;
					}
				}
			}
			map[sx][sy] = chdirec[direction];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
