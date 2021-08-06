#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, k;


struct INFO {
	int x, y;
};
const int dx[4] = { 0,0,1,-1 };
const int dy[4] = { 1,-1,0,0 };
int answer = 0;
int word[28][28];
vector<long long> num;

bool compare(int x, int y) {
	if (x > y)
		return true;
	else
		return false;
}
int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		memset(word, 0, sizeof(word));
		num.clear();
		string p;
		cin >> n >> k;
		cin >> p;
		int length = n / 4;
		for (int z = 0; z < 4; z++) {
			for (int i = 0; i < length; i++) {
				char tmp = p[(length) * z + i];
				if(tmp >= '0' && tmp <= '9')
					word[z][i] = tmp - '0';
				else if(tmp >= 'A' && tmp <= 'F')
					word[z][i] = tmp - 'A' + 10;
			}
		}
		for (int lotation = 0; lotation < length; lotation++) {
			int tmp[4];
			for (int z = 0; z < 4; z++)
				tmp[z] = word[z][length - 1];
			for (int z = 0; z < 4; z++) {
				for (int v = length - 1; v >= 1; v--)
					word[z][v] = word[z][v - 1];
			}
			for (int z = 1; z < 4; z++)
				word[z][0] = tmp[z - 1];
			word[0][0] = tmp[3];
			if (word[3][0] == 1 && word[3][1] == 15)
				int a = 0;
			for (int z = 0; z < 4; z++) {
				long long number = 0;
				int m = length - 1;
				
				for (int i = 0; i < length; i++) {
					number += pow(16, m) * word[z][i];
					m--;
				}
				num.push_back(number);
			}
		}
		sort(num.begin(), num.end(), compare);
		num.erase(unique(num.begin(), num.end()),num.end());

		cout << "#" << test_case << ' ' << num[k-1] << endl;
	}

	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
