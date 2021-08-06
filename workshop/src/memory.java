

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class memory {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int testcase = 1;testcase <=T;testcase++) {
			String n = in.readLine();
			int cnt = 0;
			for(int i = 0; i < n.length();i++) {
				if(n.charAt(i) == '1') {
					cnt = 1;
					for(int j = i; j< n.length() -1;j++) {
						if(n.charAt(j) != n.charAt(j+1)) {
							cnt++;
						}
					}
					break;
				}
			}
			System.out.println("#"+testcase+ " " + cnt);
		}
		
	}

}
