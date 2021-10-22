import java.util.Arrays;

public class PROG_입국심사 {

	public static void main(String[] args) {

	}
	//N 1명 이상 1,000,000,000명 이하
	//TIME  1분 이상 1,000,000,000분 이하
	//TIMES 1명 이상 100,000명 이하
	public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        long left = 0;
        long right = (long)times[times.length - 1] * n;
        long mid = 0;
        
        while(left <= right) {
        	mid = (left + right) / 2;
        	long Count = 0;
        	for(int t : times) {
        		Count += mid/t;
        	}
        	if(Count >= n) {
        		answer = mid;
        		right = mid - 1;
        		
        	}else {
        		left = mid + 1;
        	}
        	
        }
        return answer;
    }
}
