import java.io.*;

public class PROG_KAKAO_문자열압축 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(solution(in.readLine()));
		
	}
	public static int solution(String s) {
        int answer = s.length();
        
        for(int size = 1; size<=s.length()/2; size++) {
        	answer = Math.min(answer, check(s,size));
        	
        }
        
        
        
        return answer;
    }
	private static int check(String s, int size) {
		//int pointer = 0;
		int tmpAnswer = 0;
		for(int pointer = 0; pointer + size<= s.length();pointer+=size) {
			boolean isMatch = false;
			boolean isleast = false;
			int tmpcnt = 1;
			while(pointer+size <= s.length()) {
				if(pointer+size+size <=s.length()) {
					if(s.substring(pointer, pointer + size).equals(s.substring(pointer + size, pointer + size + size))) {
						isMatch = true;
						pointer += size;
						tmpcnt++;
					}else {
						isleast = true;
					}
				}else {
					tmpAnswer += s.length() - (pointer+size);
					break;
				}
				if(isleast)
					break;
			}
			if(isMatch == true) {
				tmpAnswer +=1;
				if(tmpcnt >= 100)
					tmpAnswer +=2;
				else if(tmpcnt>=10)
					tmpAnswer +=1;
			}
			tmpAnswer +=size;
		}
		return tmpAnswer;
	}

}
