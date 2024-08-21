class Solution {	
    
    public static boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6) {
            	try {
            		int N = Integer.parseInt(s);
            	}catch(Exception e) {
            		answer = false;
            	}
        }else {
        	answer = false;
        }
        return answer;
    }
    
}