class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean isnum[] = new boolean[10];
        
        for(int n : numbers)
            isnum[n] = true;
        for(int i=0;i<10;i++){
         if(isnum[i] == false)
             answer += i;
        }
        return answer;
    }
}