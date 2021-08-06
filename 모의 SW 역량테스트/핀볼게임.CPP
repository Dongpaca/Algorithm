#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstdio>
using namespace std;

int n, m;
const int dx[4] = { -1,1,0,0 };
const int dy[4] = { 0,0,-1,1 };

int map[102][102];
int answer;
const int wall[6][4] = {
	{1,0,3,2},
	{1,3,0,2},
	{3,0,1,2},
	{2,0,3,1},
	{1,2,3,0},
	{1,0,3,2}
};

struct INFO {
	int x, y;
};

INFO worm[2][11];
void prince()
{
	for (int i = 0; i < n + 2; i++) {
		for (int j = 0; j < n + 2; j++) {
			cout << map[i][j] << ' ';
		}
		cout << endl;
	}
	cout << endl;
}
INFO mov(int x, int y, int dir)
{
	int nx = x, ny = y;
	while (1) {
		nx += dx[dir], ny += dy[dir];
		if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
		if (map[nx][ny] != 0) break;
		x = nx, y = ny;
	}
	INFO tmp = { x,y };
	return tmp;
}
void go(int sx, int sy, int dir)
{
	int x = sx, y = sy;
	int cnt = 0;
	while (1) {
		int tmp = map[x][y];
		map[x][y] = 44;
		//prince();
		map[x][y] = tmp;
		INFO now = mov(x, y, dir);
		x = now.x, y = now.y;
		int next_thing;
		int ndir = dir;
		int nx = x + dx[dir], ny = y + dy[dir];

		next_thing = map[nx][ny];
		if ((next_thing <= 5 && next_thing >= 1)) {
			cnt++;
			ndir = wall[next_thing][dir];
		}


		//다음좌표 계산
		if (next_thing == 0) {//벽,wall5 
			//nx = x, ny = y;
		}
		else if (next_thing <= 5 && next_thing >= 1) {
			//nx += dx[ndir], ny += dy[ndir];
		}
		if (next_thing <= 10 && next_thing >= 6) {
			if (worm[0][next_thing].x == nx && worm[0][next_thing].y == ny)
				nx = worm[1][next_thing].x, ny = worm[1][next_thing].y;
			else
				nx = worm[0][next_thing].x, ny = worm[0][next_thing].y;

			//nx += dx[ndir], ny += dy[ndir];
		}

		dir = ndir;
		x = nx, y = ny;
		if (next_thing == -1) break;
		if (next_thing == -2) break;

	}
	if (cnt > answer)
		answer = cnt;
	return;
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n;
		answer = 0;
		memset(worm, -1, sizeof(worm));

		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				map[i][j] = 5;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				cin >> map[i][j];//0 빈칸 1-5 블록 -1 블랙홀 6-10 웜홀
				if (map[i][j] >= 6 && map[i][j] <= 10) {
					if (worm[0][map[i][j]].x == -1 && worm[0][map[i][j]].y == -1) {
						worm[0][map[i][j]] = { i,j };
					}
					else {
						worm[1][map[i][j]] = { i,j };
					}
				}
			}
		}
		//prince();

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (map[i][j] != 0) continue;
				for (int dir = 0; dir < 4; dir++) {
					//cout << "start ==== " << dir << "=======" << endl;
					map[i][j] = -2;
					go(i, j, dir);
					map[i][j] = 0;
				}
			}
		}

		cout << "#" << test_case << ' ' << answer << endl;
	}

	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
