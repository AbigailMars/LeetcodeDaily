import java.util.HashSet;
public class lengthOfLongestSubstring{
	   public int lengthOfLongestSubstring(String s) {
	        int start = 0;
	        int end = 0;
	        int maxLength = 0;
	        HashSet record = new HashSet();
	        while(end < s.length()){
	            if(record.add(s.charAt(end))){
	                end++;
	            }else{
	                record.remove(s.charAt(start++));
	            }
	            if(maxLength < end - start){
	                maxLength = end - start;
	            }
	        }
	        return maxLength;
	    }
	   //Runtime: 6 ms, faster than 59.46% of Java online submissions for Longest Substring Without Repeating Characters.
	   //Memory Usage: 39.1 MB, less than 49.81% of Java online submissions for Longest Substring Without Repeating Characters.
}
