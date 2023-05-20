import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> q = new ArrayDeque<>();
        q.offer(begin);
        Queue<Integer> iQ = new ArrayDeque<>();
        iQ.offer(0);
        boolean[] visited = new boolean[words.length];
        
        while(true){
            String temp = q.poll();
            int iTemp = iQ.poll();
            
            if(temp.equals(target)){
                return iTemp;
            }
            
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i]){
                    int cnt = 0;
                    for(int j = 0; j < temp.length(); j++){
                        if(temp.charAt(j) != words[i].charAt(j)) cnt++;
                    }
                    
                    if(cnt == 1){
                        q.offer(words[i]);
                        iQ.offer(iTemp+1);
                        visited[i] = true;
                    }
                }
            }
            
            if(q.isEmpty()){
                return 0;
            }
        }

    }
}