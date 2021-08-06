#include<iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int dx[5] = { 0,-1,0,1,0 };
int dy[5] = { 0,0,1,0,-1 };

int main(int argc, char** argv)
{
	int test_case;
	int T;
	//freopen("input.txt", "r", stdin);
	cin >> T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int m, na;
		cin >> m >> na;
		vector<int> map[10][10];
		memset(map, 0, sizeof(0));
		vector<int> u1(m), u2(m);
		for (int i = 0; i < m; i++)
			cin >> u1[i];
		for (int i = 0; i < m; i++)
			cin >> u2[i];
		vector<int> a(na + 1);
		for (int i = 1; i <= na; i++) {
			int x, y, c, p;
			cin >> y >> x >> c >> p;
			a[i] = p;
			y--; x--;
			for (int j = x - c; j <= x + c; j++) {
				for (int k = y - c; k <= y + c; k++) {
					if (j < 0 || j >= 10 || k < 0 || k >= 10) continue;
					int t = abs(j - x) + abs(k - y);
					if (t <= c) {
						map[j][k].push_back(i);
					}
				}
			}
		}
		int x1, x2, y1, y2;
		x1 = y1 = 0;
		x2 = y2 = 9;
		int sum1, sum2;
		sum1 = sum2 = 0;
		for (int i = 0; i <= m; i++) {
			int sz1, sz2;
			sz1 = map[x1][y1].size();
			sz2 = map[x2][y2].size();
			if (sz1 > 0 && sz2 == 0) {
				int mx = 0;
				for (int k = 0; k < sz1; k++)
					mx = max(a[map[x1][y1][k]], mx);
				sum1 += mx;
			}
			else if(sz1 == 0 && sz2 > 0) {
				int mx = 0;
				for (int k = 0; k < sz2; k++)
					mx = max(a[map[x2][y2][k]], mx);
				sum2 += mx;
			}
			else if (sz1 > 0 && sz2 > 0) {
				int mx = 0;
				int s1, s2;
				s1 = s2 = 0;
				for (int k = 0; k < sz1; k++) {
					for (int z = 0; z < sz2; z++) {
						int t1, t2;
						if (map[x1][y1][k] != map[x2][y2][z]) {
							t1 = a[map[x1][y1][k]];
							t2 = a[map[x2][y2][z]];

						}
						else {
							t1 = t2 = a[map[x1][y1][k]] / 2;
						}
						if (t1 + t2 > s1 + s2) {
							s1 = t1; s2 = t2;
						}
					}
				}
				sum1 += s1; sum2 += s2;
			}
			if (i == m) break;
			x1 += dx[u1[i]]; y1 += dy[u1[i]];
			x2 += dx[u2[i]]; y2 += dy[u2[i]];
		}
		cout << "#" << test_case << ' ';
		cout << sum1 + sum2 << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
