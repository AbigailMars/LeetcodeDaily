import java.util.Hashtable;
public class numKLenSubstrNoRepeats {
	    public int numKLenSubstrNoRepeats(String S, int K) {
	        char[] string = S.toCharArray();
	        int start = 0; 
	        int end = 0;
	        Hashtable<Character, Integer> repeated = new Hashtable<Character,Integer>();
	        int number = 0;
	        while (end < string.length){             
	            if(repeated.get(string[end]) == null){ 
	                repeated.put(string[end],end); 
	                end++;                 
	              }else{
	                repeated.remove(string[start++]);               
	                   }
	            
	            if(end - start  == K){
	               repeated.remove(string[start++]);           
	               number++; 
	               }            
	           }
	        return number;
	    }
	    //Runtime: 8 ms, faster than 56.94% of Java online submissions for Find K-Length Substrings With No Repeated Characters.
	    //Memory Usage: 39 MB, less than 40.58% of Java online submissions for Find K-Length Substrings With No Repeated Characters.
	    
	    public int numKLenSubstrNoRepeats1(String S, int K) {
	        
	        int i = 0;
	        int j = 0;
	        int out = 0;
	        Set<Character> cache = new HashSet<>();
	        
	        while(j < S.length()) {
	            char c = S.charAt(j);
	            if(cache.add(c)) {
	                j++;
	            }else{
	               cache.remove(S.charAt(i++));
	                 }
	            if(j - i == K) {
	            out ++;
	            cache.remove(S.charAt(i++));
	            }
	        }	        
	        return out;        
	    }
	    //Runtime: 7 ms, faster than 74.12% of Java online submissions for Find K-Length Substrings With No Repeated Characters.
	    //Memory Usage: 39.1 MB, less than 31.88% of Java online submissions for Find K-Length Substrings With No Repeated Characters.	
	    
	    public int numKLenSubstrNoRepeats2(String S, int K) {
	        if(S.length() < K) {
	            return 0;
	        }
	        int left = 0, right = 0;
	        int[] count = new int[26];
	        while(right < K) {
	            count[S.charAt(right++) - 'a']++;
	        } // set the constant length K  and the first K subarray
	        
	        int result = isUnique(count)?1:0; // set the fitst K length subarray result
	        
	        while(right < S.length()) {
	            count[S.charAt(left++) - 'a']--; // remove left one step and right one step 
	            count[S.charAt(right++) - 'a']++;
	            result += isUnique(count) ? 1 : 0;//compute the number of no repeats subarray
	        }
	        return result;
	    }
	    
	    private boolean isUnique(int[] count) {
	        for(int cnt:count) {
	            if(cnt > 1) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	   //Runtime: 3 ms, faster than 93.58% of Java online submissions for Find K-Length Substrings With No Repeated Characters.
	   //Memory Usage: 37.4 MB, less than 84.06% of Java online submissions for Find K-Length Substrings With No Repeated Characters.
}
