import java.io.*;
import java.util.*;

class Pair {
	int height;
	int idx;
	
	Pair(int height, int idx) {
		this.height = height;
		this.idx = idx;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
}
public class Solution_2493_탑 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		List<Integer> tower = new ArrayList<>();
		Stack<Pair> rest = new Stack<>();
		List<Integer> rader = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<N;i++) {
			tower.add(Integer.parseInt(st.nextToken()));
			rader.add(0);
		}
		for(int i=0;i<N;i++) {
			if(rest.isEmpty()) {
				rest.push(new Pair(tower.get(i),i));
				rader.set(i, 0);
				continue;
			}else {
				while(true) {
					if(rest.peek().height >= tower.get(i)) {
						rader.set(i, rest.peek().idx + 1);
						rest.push(new Pair(tower.get(i),i));
						break;
					}else if(rest.peek().height  < tower.get(i)) {
						rest.pop();
					}
					if(rest.isEmpty()) {
						rest.push(new Pair(tower.get(i),i));
						rader.set(i, 0);
						break;
					}
				}
				
			}
		}
		for(int i=0;i<rader.size();i++) {
			sb.append(rader.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
}
