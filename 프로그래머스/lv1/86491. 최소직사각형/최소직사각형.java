import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 큰 변, 작은 변끼리 모아버리기
        for(int i = 0; i < sizes.length; i++){
            Arrays.sort(sizes[i]);
        }
        
        int rMax = 0;
        int cMax = 0;
        for(int i = 0; i < sizes.length; i++){
            rMax = Math.max(rMax, sizes[i][0]);
            cMax = Math.max(cMax, sizes[i][1]);
        }
        
        return rMax * cMax;
    }
}