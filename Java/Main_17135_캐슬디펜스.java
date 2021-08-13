 import java.io.*;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] origin_map,copy_map;
	static int[][] archer = new int[3][3];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		origin_map = new int[N][M];
		copy_map = new int[N][M];
		int enemyCnt = 0;//남은 적 숫자
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				origin_map[i][j] = Integer.parseInt(st.nextToken());
				if(origin_map[i][j] == 1) enemyCnt++;
			}
		}
		
		
		int result = 0;
		for (int a1 = 0; a1 < M; a1++) {
			for (int a2 = a1 + 1; a2 < M; a2++) {
				for (int a3 = a2 + 1; a3 < M; a3++) {//궁수위치 조합
					for(int i=0;i<N;i++)
						copy_map[i] = origin_map[i].clone();//DEEP COPY로 맵 복사
					int enemyCnttmp = enemyCnt;//남은 적 숫자
					int killenemyCnt = 0;//죽인 적의 숫자
					while (enemyCnttmp > 0) {//남은 적 0이면 게임 종료
						boolean[] flag = findenemy(copy_map,new int[] {a1, a2, a3}); //적을 찾는것 까지만, flag는 동시에 한명 공격할 수 있어서
						for(int f=0;f<3;f++) {//적 삭제 & 적 카운트 -1
							if(flag[f] == true && copy_map[archer[f][0]][archer[f][1]] == 1) {//적이 있으면 죽이기
								copy_map[archer[f][0]][archer[f][1]] = 0;
								enemyCnttmp--;
								killenemyCnt++;
							}
						}
						//적 아래로 한칸 이동
						for(int j=0;j<M;j++) {//성안으로 들어가는 적 카운트
							if(copy_map[N-1][j] == 1) {
								enemyCnttmp--;
							}
						}
						for(int i=N-1;i>0;i--) {//한칸씩 밑으로 시프트
							for(int j=0;j<M;j++) {
								copy_map[i][j] = copy_map[i-1][j];
							}
						}
						for(int j=0;j<M;j++)//제일 윗줄 0으로 초기화
							copy_map[0][j] = 0;
					}
					if(result < killenemyCnt)//최대 공격숫자 업데이트
						result = killenemyCnt;
					
				}
			}
		}
		System.out.println(result);
	}

	private static boolean[] findenemy(int[][] copy_map, int[] a) {
		boolean[] flag = new boolean[] { false, false, false };
		
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (copy_map[i][j] == 1) { // 적이 있으면 후보
					for (int f = 0; f < 3; f++) {
						int dx = N - i;
						int dy = a[f] - j;
						if(dy < 0) dy = -dy;//궁수 위치로부터 적 거리재기
						if(D >= (dx+dy)) {
							if(flag[f] == true) {// 이미 쏜 사람 기준 더 짧은 거리이면 업데이트
								if(dx+dy < archer[f][2]) {
									archer[f] = new int[] {i,j,dx+dy};
								}
							}else {// 처음 쏜 사람이면 공격 적 위치 입력
								archer[f] = new int[] {i,j,dx+dy};
								flag[f] = true;
							}
						}
							
					}
				}
			}
		}
		
		return flag;
	}

}
