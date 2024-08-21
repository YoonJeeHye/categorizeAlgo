import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        int a = 0;
        for(int i = 0; i < my_string.length(); i++) {
            int num = my_string.charAt(i) - '0';
            if(num >= 0 && num <= 9) {
                list.add(num);
                a++;
            }
        }
        int[] answer = new int[a];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}