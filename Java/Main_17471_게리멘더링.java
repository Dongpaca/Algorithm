import java.io.*;
import java.util.*;

public class Main_17471_게리멘더링 {
	static int N;
	static int[] population;
	static int[][]map;
	static int result = -1;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		population = new int[N+1];
		map = new int[11][11];
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for(int i=1;i<=N;i++)
			population[i] = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			int tn = Integer.parseInt(st.nextToken());
			map[i] = new int[tn+1];
			map[i][0] = tn;
			for(int j=1;j<=tn;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		List<Integer>district1 =new LinkedList<Integer>(),district2 = new LinkedList<Integer>();
		
		combination(1,district1,district2);
		System.out.println(result);
	}
	private static void combination(int idx, List<Integer> district1,List<Integer> district2) {
		if(idx > N) {
			if(district1.size() != 0 && district2.size() != 0 && district1.size() + district2.size() == N) {
				if(checkmap(district1,district2)) {
					int sumd1 =0,sumd2 =0;
					for(int i=0;i<district1.size();i++)
						sumd1+=population[district1.get(i)];
					for(int i=0;i<district2.size();i++)
						sumd2+=population[district2.get(i)];
					if(result == -1 || result > Math.abs(sumd1-sumd2))
						result = Math.abs(sumd1-sumd2);
				}
			}
			return;
		}
		
		district1.add(idx);
		combination(idx + 1, district1,district2);
		district1.remove(district1.size() -1);
		
		district2.add(idx);
		combination(idx + 1, district1,district2);
		district2.remove(district2.size() -1);
		
	}
	private static boolean checkmap(List<Integer> district1, List<Integer> district2) {
		boolean isSafe = true;
		int[] checkdistrict1 = new int[N+1];
		int[] checkdistrict2 = new int[N+1];
		int[] isvisited = new int[N+1];
		for(int i=1;i<=N;i++) {
			isvisited[i] = 0;
		}
		for(int i=0;i<district1.size();i++) {
			checkdistrict1[district1.get(i)] = 1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(district1.get(0));
		while(!q.isEmpty()) {
			int x = q.poll();
			isvisited[x] = 1;
			for(int j=1;j<=map[x][0];j++) {
				if(isvisited[map[x][j]] == 1) continue;
				if(checkdistrict1[map[x][j]] != 1) continue;
				q.add(map[x][j]);
				isvisited[map[x][j]] = 1;
			}
		}
		for(int i=0;i<district1.size();i++) {
			if(isvisited[district1.get(i)] == 0)
				isSafe = false;
		}
		for(int i=1;i<=N;i++)
			isvisited[i] = 0;
		for(int i=0;i<district2.size();i++) {
			checkdistrict2[district2.get(i)] = 1;
		}
		q.add(district2.get(0));
		while(!q.isEmpty()) {
			int x = q.poll();
			isvisited[x] = 1;
			for(int j=1;j<=map[x][0];j++) {
				if(isvisited[map[x][j]] == 1) continue;
				if(checkdistrict2[map[x][j]] != 1) continue;
				q.add(map[x][j]);
				isvisited[map[x][j]] = 1;
			}
		}
		for(int i=0;i<district2.size();i++) {
			if(isvisited[district2.get(i)] == 0)
				isSafe = false;
		}
		return isSafe;
	}

}
