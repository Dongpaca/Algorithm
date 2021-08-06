#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <cstring>
using namespace std;

int n,m;
int k;

struct data_type {
	int state;//0 아무것도 없음, 1 활성화, 2 비활성화 , 3 죽은 세포
	//lp 생명력
	int lp, hp; // 활성화까지 남은 시간, hp 비활까지 남은 시간
};

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
data_type a[2][352][352];
int main(int argc, char** argv)
{
	int test_case;
	int T;
	//freopen("input.txt", "r", stdin);
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n >> m >> k;
		
		memset(a, 0, sizeof(a));

		for (int i = 0 + k / 2 + 1; i < n + k / 2 + 1; i++) {
			for (int j = 0 + k / 2 + 1; j < m + k / 2 + 1; j++) {
				cin >> a[0][i][j].lp;
				if (a[0][i][j].lp > 0) {
					a[0][i][j].state = 2;
					a[0][i][j].hp = 0;
				}
			}
		}

		int cur = 0;
		for (int t = 0; t < k; t++) {
			for (int i = 0; i < n + k + 2; i++) {
				for (int j = 0; j < m + k + 2; j++) {
					
					if (a[cur][i][j].state == 3) {
						a[1 - cur][i][j].state = 3;
						continue;
					}
					else if (a[cur][i][j].state == 2) {
						a[1 - cur][i][j].hp = a[cur][i][j].hp + 1;
						a[1 - cur][i][j].lp = a[cur][i][j].lp;
						if (a[1 - cur][i][j].hp == a[cur][i][j].lp) {
							a[1 - cur][i][j].state = 1;
						}
						else {
							a[1 - cur][i][j].state = 2;
						}
					}
					else if (a[cur][i][j].state == 1) {
						if (a[cur][i][j].hp == a[cur][i][j].lp) {
							for (int k = 0; k < 4; k++) {
								int nx = i + dx[k]; int ny = j + dy[k];

								if (a[cur][nx][ny].state == 0) {
									if (a[1 - cur][nx][ny].state == 0) {
										a[1 - cur][nx][ny].state = 2;
										a[1 - cur][nx][ny].lp = a[cur][i][j].lp;
										a[1 - cur][nx][ny].hp = 0;
									}
									else if (a[1 - cur][nx][ny].state == 2 && a[1 - cur][nx][ny].lp < a[cur][i][j].lp) {
					
										a[1 - cur][nx][ny].lp = a[cur][i][j].lp;
									}
								}
								
							}
						}
						a[1 - cur][i][j].hp = a[cur][i][j].hp - 1;

						if (a[1 - cur][i][j].hp == 0) {
							a[1 - cur][i][j].state = 3;
						}
						else {
							a[1 - cur][i][j].state = 1;
						}
					}
				}
			}
			cur = 1 - cur;
		}
		int ans = 0;
		for (int i = 0; i < n + k + 2; i++) {
			for (int j = 0; j < m + k + 2; j++) {
				if (a[cur][i][j].state == 1 || a[cur][i][j].state == 2) {
					ans++;
				}
			}
		}
		cout << '#' << test_case << ' ';
		cout << ans << '\n';
	}

	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}

