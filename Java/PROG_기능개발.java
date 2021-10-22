import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int pro[] = {95, 90, 99, 99, 80, 99};
		//int spe[]  = {1, 1, 1, 1, 1, 1};
		//solution(pro,spe);
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int restDay[] = new int[speeds.length];
        
        for(int i=0;i<progresses.length;i++) {
        	int r = 100 - progresses[i];
        	restDay[i] = r/speeds[i];
        	if(r%speeds[i] != 0)
        		restDay[i] += 1;
        }
        List<Integer> list = new LinkedList<Integer>();
        int pos = 0;
        while(pos < progresses.length) {
        	int cnt = 1;
        	int tmp = restDay[pos];
        	while(pos + cnt < progresses.length && tmp >= restDay[pos+cnt]) {
        		cnt++;
        	}
        	list.add(cnt);
        	pos += cnt;
        }
         answer = new int[list.size()];
        for(int i = 0;i<list.size();i++)
        	answer[i] = list.get(i);
        return answer;
    }
}