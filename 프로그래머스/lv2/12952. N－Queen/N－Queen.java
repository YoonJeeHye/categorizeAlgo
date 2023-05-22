import java.util.*;

class Solution {
    
    // 대각선에 있는지 확인하기 위한 대각선 r,c
    static int[] dr = {};
    static int[] dc = {};
    // 순열 만들때 쓰일 배열
    static boolean[] visited;
    static int[] nums;
    static int answer;
    public int solution(int n) {
        answer = 0;
        
        // 퀸을 배치하는 순열을 구한다
        visited = new boolean[n];
        nums = new int[n];
        Perm(0, n);
        
        return answer;
    }
    
    public void Perm(int idx, int n){
        if(idx == n){
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            nums[idx] = i;
            
            // 퀸 놓을 수 있는 곳이면 다음 퀸 놓으러 간다
            if(Available(idx, i)) Perm(idx+1, n);
        }
    }
    
    public boolean Available(int r, int c){
        // 상, 위쪽 대각선들 확인
        for(int i = 1; i <= r; i++){
            if(nums[r-i] == c) return false;
            else if(nums[r-i] == c-i) return false;
            else if(nums[r-i] == c+i) return false;
        }
        return true;
    }
    
}