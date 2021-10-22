import java.util.Arrays;

public class PROG_124나라의숫자 {
	static int number[] = {1,2,4};
	static int createCnt = 1;
	static boolean isSuccess = false;
	static int resultNum[];
	public static void main(String[] args) {
		int n = 3;
		solution(n);

	}
	public static String solution(int n) {
        String answer = "";
        
        long cntSum = 3;
        int digit = 1;
        long preCnt = 0;
        while(true) {
        	if(cntSum >= n) {
        		
        		break;
        	}
        	
        	preCnt = cntSum;
        	digit++;
        	cntSum += Math.pow(3, digit);
        }
//        if(n <=3)
//        	preCnt = n;
        int num[] = new int[digit];
        int restCnt = n - (int)preCnt;
        
        per(num,0,digit,restCnt);
        StringBuilder answerTmp = new StringBuilder();
        for(int a : resultNum) {
        	answerTmp.append(a );
        }
        System.out.println(answerTmp.toString());
        return answerTmp.toString();
    }
	private static void per(int[] num, int idx,int digit,int restCnt) {
		if(isSuccess)
			return;
		if(idx == digit) {
			if(createCnt == restCnt) {
				resultNum = num.clone();
				isSuccess = true;
			}
			
			createCnt++;
			return;
		}
		for(int i=0;i<3;i++) {
			num[idx] = number[i];
			per(num,idx + 1,digit,restCnt);
		}
	}
	
}
