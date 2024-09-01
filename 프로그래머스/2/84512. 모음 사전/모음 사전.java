import java.util.*;

// DFS로 다 만들어놓고 찾기
class Solution {
    static String str;
    static List<String> list;
    static char[] wc = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int result = 0;
        
        str = "";
        list = new ArrayList<>();
        DFS(str);
        
        for(int i = 0; i < list.size(); i++) {
            if(word.equals(list.get(i))) {
                result = i;
                break;
            }
        }
        
        return result;
    }
    
    public void DFS(String str) {
        list.add(str);
        
        if(str.length() == 5)
            return;
            
        for(int i = 0; i < 5; i++) {
            DFS(str + wc[i]);
        }
    }
}