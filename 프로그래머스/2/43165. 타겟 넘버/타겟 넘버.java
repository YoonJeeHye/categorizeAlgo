import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        DFS(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int target, int sum, int n) {
        if(numbers.length == n) {
            if(target == sum) {
                answer++;
            }
            return;
        }
        DFS(numbers, target, sum + numbers[n], n+1);
        DFS(numbers, target, sum - numbers[n], n+1);
    }
}