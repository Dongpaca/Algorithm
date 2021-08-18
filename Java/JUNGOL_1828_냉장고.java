import java.io.*;
import java.util.*;

public class JUNGOL_1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		Chemistry[] chemistry = new Chemistry[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			chemistry[i] = new Chemistry( Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(chemistry);
		
		int refrigeratorCnt = 1;
		List<Chemistry> list = new LinkedList<Chemistry>();
		list.add(chemistry[0]);
		for(int i=1;i<N;i++) {
			if(list.get(list.size() - 1).max < chemistry[i].min) {
				list.add(chemistry[i]);
				refrigeratorCnt++;
			}
		}
		
		System.out.println(refrigeratorCnt);
	}
	
}
class Chemistry implements Comparable<Chemistry>{
	
	int min;
	int max;
	
	public Chemistry(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public int compareTo(Chemistry o) {
		int value = this.max - o.max;
		if(value != 0 ) return value;
		
		
		return this.min - o.min;
	}

	@Override
	public String toString() {
		return "Chemistry [min=" + min + ", max=" + max + "]";
	}
	
	
}