class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0;i<absolutes.length;i++){
            int  tmp = absolutes[i];
            if(!signs[i])
                tmp = -tmp;
            answer += tmp;
        }
        
        return answer;
    }
}