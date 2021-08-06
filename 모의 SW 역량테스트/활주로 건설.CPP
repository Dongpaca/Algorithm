#include<iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int n, k;

bool go(vector<int> h)
{
	bool ok = true;
	vector<int> check(n);
	for (int i = 0; i < n - 1; i++) {
		int g = h[i] - h[i + 1];
		if (abs(g) >= 2) {
			ok = false;
			break;
		}
		else if (g == 0) continue;
		else if(g == 1){//h[i] > h[i+1]
			int num = h[i + 1];
			for (int z = i + 1; z < i + 1 + k; z++) {
				if (z < 0 || z >= n || h[z] != num) {
					ok = false;
					break;
				}
				else if (check[z] == true) {
					ok = false;
					break;
				}
				check[z] = true;
			}
		}
		else if (g == -1) {//h[i] < h[i+1]
			int num = h[i];
			for (int z = i; z >= i - k + 1; z--) {
				if (z < 0 || z >= n || h[z] != num) {
					ok = false;
					break;
				}
				else if (check[z] == true) {
					ok = false;
					break;
				}
				check[z] = true;
			}
		}
		if (ok == false)
			break;
	}
	return ok;
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n >> k;

		vector<vector<int>> a(n, vector<int>(n));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> a[i][j];
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			vector<int> tmp(n);
			for (int j = 0; j < n; j++) {
				tmp[j] = a[i][j];
			}
			if (go(tmp))
				ans++;
		}
		for (int i = 0; i < n; i++) {
			vector<int> tmp(n);
			for (int j = 0; j < n; j++) {
				tmp[j] = a[j][i];
			}
			if (go(tmp))
				ans++;
		}
		cout << "#" << test_case << ' ';
		cout << ans << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}

