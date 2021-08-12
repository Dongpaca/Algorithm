import java.io.*;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	static int N;
	static int[] bitter;
	static int[] sour;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		bitter = new int[N];
		sour = new int[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
			
		}
		long result = Integer.MAX_VALUE;
		for(int bit=1;bit<(1<<N);bit++) {
			long multipleofSour =1;
			long sumofBitter = 0;
			for(int j=0;j<N;j++) {
				if((bit&(1<<j)) != 0) {
					multipleofSour*=sour[j];
					sumofBitter += bitter[j];
				}
			}
			long tmp =multipleofSour - sumofBitter;
			if(tmp < 0) tmp = -tmp;
			result = Math.min(tmp,result);
			
		}
		System.out.println(result);
		
	}

}
