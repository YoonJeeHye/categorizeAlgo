import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String[] n_skill_trees = new String[skill_trees.length];
        Arrays.fill(n_skill_trees,"");
        boolean[] b_skill_trees = new boolean[skill_trees.length];
        Arrays.fill(b_skill_trees,true);
        
        for(int i = 0; i < skill_trees.length; i++) {
            for(int j = 0; j < skill_trees[i].length(); j++) {
                for(int s = 0; s < skill.length(); s++) {
                    if(skill.charAt(s) == skill_trees[i].charAt(j)) {
                        n_skill_trees[i] += skill_trees[i].charAt(j);
                    }
                }
            }
        }
        
        Queue<Character> q = new ArrayDeque<>();
        for(int i = 0; i < n_skill_trees.length; i++) {
            for(int j = 0; j < n_skill_trees[i].length(); j++) {
                q.add(n_skill_trees[i].charAt(j));
            }
            
            for(int s = 0; s < skill.length(); s++) {
                if(q.size() != 0 && b_skill_trees[i]) {
                    if(q.peek() != skill.charAt(s)) b_skill_trees[i] = false;
                    else if(q.peek() == skill.charAt(s)) q.poll();
                }
            }
            
            if(q.size() == 0) answer++;
            
            q.clear();
        }
        
        return answer;
    }
}