import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            sum += i;
            if(sum == n) {
                answer++;
                break;
            }
            for(int j = i+1; j <= n; j++) {
                if(sum + j == n) {
                    answer++;
                    break;
                } else if(sum + j > n) {
                    break;
                }
                sum += j;
            }
        }
        return answer;
    }
}