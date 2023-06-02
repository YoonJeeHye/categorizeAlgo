import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] village = new int[N][N];    // 각 마을별 걸리는 시간 저장
        for(int i = 0; i < N; i++){
            Arrays.fill(village[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < road.length; i++){
            if(village[road[i][0]-1][road[i][1]-1] > road[i][2]){   // 겹치는 경로는 최소값을 저장
                village[road[i][0]-1][road[i][1]-1] = road[i][2];
                village[road[i][1]-1][road[i][0]-1] = road[i][2];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(village[i][j] == Integer.MAX_VALUE)
                    village[i][j] = 0;
            }
        }

        int[] minDist = new int[N];   // 마을1부터 각 마을별 최소 거리 저장
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        boolean[] visited = new boolean[N];   // 방문 마을 체크
        
        minDist[0] = 0; // 마을1 ~ 마을1 거리는 0
        
        int min;
        int minVertex;
        for(int i = 0; i < N; i++){     // 하나의 마을을 기준으로 잡는다
            min = Integer.MAX_VALUE;    // 최소값 찾는용
            minVertex = -1;             // 최소값 인덱스
            for(int j = 0; j < N; j++){ // 해당 마을에 대해 다른 마을들을 돌려본다
                if(!visited[j] && min > minDist[j]){
                    min = minDist[j];   // 최소값 찾기
                    minVertex = j;
                }
            }
            visited[minVertex] = true;  // 방문처리
            
            // 지금 방문처리된 마을과 연결돼있는 마을들을 찾아 최소값 갱신
            for(int j = 0; j < N; j++){
                // 방문전 && 지금 방문처리된 마을과 연결 && 최소값일 경우 갱신
                if(!visited[j] && village[minVertex][j] != 0 && minDist[j] > minDist[minVertex] + village[minVertex][j]){
                    minDist[j] = minDist[minVertex] + village[minVertex][j];
                }
            }
        }
        
        // 조건 K에 해당하는 마을 개수 구하기
        for(int i = 0; i < N; i++){
            if(minDist[i] <= K) answer++;
        }
        
        return answer;
    }
}