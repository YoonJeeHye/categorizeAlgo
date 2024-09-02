import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<int[]> q;
    static int ans;
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 1});
        BFS(0, 0, maps);
        
        return ans;
    }
    
    public void BFS(int x, int y, int[][] maps) {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int d = 0; d < 4; d++) {
                int nx = now[0] + dr[d];
                int ny = now[1] + dc[d];

                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length)
                    continue;

                if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                    if(nx == maps.length-1 && ny == maps[0].length-1) {
                        ans = now[2]+1;
                        return;
                    }
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, now[2]+1});
                }
            }
        }
        ans = -1;
        return;
    }
}