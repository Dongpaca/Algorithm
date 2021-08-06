#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstdio>
using namespace std;

const int dx[4] = { 1,1,-1,-1 };
const int dy[4] = { 1,-1,-1,1 };

struct INFO {
	int x, y;
};
int map[20][20];
int n;

int go(INFO now, int r, int l)
{
	vector<int> num;
	int x = now.x, y = now.y;
	if (x == 3 && y == 1)
		int a = 0;
	for (int i = 0; i < r - 1; i++) {
		num.push_back(map[x][y]);
		x += dx[0], y += dy[0];
	}
	for (int i = 0; i < l - 1; i++) {
		num.push_back(map[x][y]);
		x += dx[1], y += dy[1];
	}
	for (int i = 0; i < r - 1; i++) {
		num.push_back(map[x][y]);
		x += dx[2], y += dy[2];
	}
	for (int i = 0; i < l - 1; i++) {
		num.push_back(map[x][y]);
		x += dx[3], y += dy[3];
	}
	int ans = num.size();
	sort(num.begin(), num.end());
	num.erase(unique(num.begin(), num.end()),num.end());
	int tmp = num.size();
	if (ans == tmp)
		return ans;
	else
		return -1;
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> map[i][j];
			}
		}
		int answer = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				INFO start = { i,j };
				for (int r = 2; r <= n - start.y; r++) {
					for (int l = 2; l <= start.y + 1; l++) {
						if (r + l - 2 > n - i - 1) continue;
						 int ret = go(start, r , l);
						 if (ret > answer)
							 answer = ret;
					}
				}
			}
		}
		cout << "#" << test_case << ' ' << answer << endl;
	}

	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
