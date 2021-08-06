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

int map[100][100];

int answer;
struct INFO {
	int x, y;
};

int house(int x, int y, int k)
{
	int cnt = 0;

	for (int i = x - (k - 1), z = 0; i <= x; i++, z++) {
		for (int j = y - z; j <= y + z; j++) {
			if (map[i][j] == 1)
				cnt++;
		}
	}
	for (int i = x + (k - 1), z = 0; i > x; i--, z++) {
		for (int j = y - z; j <= y + z; j++) {
			if (map[i][j] == 1)
				cnt++;
		}
	}


	return cnt;
}

void house2(int x, int y, int k)
{
	int map[50][50];
	memset(map, 0, sizeof(map));
	int cnt = 0;

	for (int i = x - (k - 1), z = 0; i <= x; i++, z++) {
		for (int j = y - z; j <= y + z; j++) {
			if (map[i][j] == 1)
				cnt++;
			map[i][j] = 9;
		}
	}
	for (int i = x + (k - 1), z = 0; i > x; i--, z++) {
		for (int j = y - z; j <= y + z; j++) {
			if (map[i][j] == 1)
				cnt++;
			map[i][j] = 9;
		}
	}
	for (int i = 0; i < 50; i++) {
		for (int j = 0; j < 50; j++) {
			cout << map[i][j] << ' ';
		}
		cout << endl;
	}
	cout << endl;

	return;
}
void prince() {
	for (int i = 0; i < 50; i++) {
		for (int j = 0; j < 50; j++) {
			cout << map[i][j] << ' ';
		}
		cout << endl;
	}
	cout << endl;
}
int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n >> m;

		memset(map, 0, sizeof(map));
		for (int i = 25; i < n + 25; i++) {
			for (int j = 25; j < n + 25; j++) {
				cin >> map[i][j];
			}
		}
		int k = 1;
		answer = 0;
		//prince();
		while (1) {
			int tmp_max_num = 0;
			int tmp_num = 0;
			int cost = k * k + (k - 1) * (k - 1);
			for (int i = 25; i < n + 25; i++) {
				for (int j = 25; j < n + 25; j++) {
					if (i == 28 && j == 28 && k == 4)
						int a = 0;
					tmp_num = house(i, j, k);
					
					if (tmp_num == 11)
						int a = 0;
					if (tmp_max_num < tmp_num)
						tmp_max_num = tmp_num;
				}
			}
			if (tmp_max_num * m >= cost) {
				answer = tmp_max_num;
			}
			if(k > 20)
				break;
			k++;
		}
		
		cout << "#" << test_case << ' ' << answer << endl;
	}

	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
