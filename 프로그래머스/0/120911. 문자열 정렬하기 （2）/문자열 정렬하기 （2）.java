import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] arr = new char[my_string.length()];
        
        int diff = 'a' - 'A';
        for(int i = 0; i < my_string.length(); i++) {
            if(my_string.charAt(i) >= 'A' && my_string.charAt(i) <= 'Z') {
                arr[i] = (char)(my_string.charAt(i) + diff);
            } else {
                arr[i] = (char)(my_string.charAt(i));
            }
        }
        Arrays.sort(arr);
        for(int i = 0; i < my_string.length(); i++) {
            answer += arr[i];
        }
        
        return answer;
    }
}