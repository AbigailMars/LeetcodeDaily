 
class Solution {
//Answer by my own
    public int lengthOfLongestSubstring1(String s) {
       int start = 0;
       int maxLength = 0;
       int count = 0;
       char[] c;
       if(s.length()!= 0){
          c = new char[s.length()];
           for(int i = 0; i < s.length();i++){
            c[i] = s.charAt(i);
           for(int j = i-1;j >= start;j--){
               if(c[j] == c[i] && i != 0){                   
                   start = j+1;
                   count = i - start;                       
                   break;
               }              
           } 
         count = count + 1;
         if(maxLength < count){
            maxLength = count;
         }
        }
         }
             return maxLength;
    }
/*
Runtime: 4 ms, faster than 88.32% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 38.8 MB, less than 92.64% of Java online submissions for Longest Substring Without Repeating Characters.
*/
    
// Approach 1: Brute Force
    public int lengthOfLongestSubstring2(String s) {
     int n = s.length();
        
     int res = 0;
        //n * n  iterate every possibilities of substrings
        for(int i = 0 ;i < n;i++){
            for(int j = i;j < n;j++){
                if(checkRepetition(s,i,j)){
                    res = Math.max(res,j-i+1);
                }
            }
        }
        return res;
 }
    private boolean checkRepetition(String s,int start,int end){
        //if 128 characters 
        int[] chars = new int[128];  
        
        for(int  i = start;i<= end;i++){
            char c = s.charAt(i);
        //if char c appears more than 1, then count > 1;
            chars[c]++;
            if(chars[c] > 1){
                return false; 
            }
        }
        
        return true;
    }
    
/*
Complexity Analysis:
Time complexity : O(n^3)
Space complexity : O(min(n, m)). We need O(k) space for checking a substring has no duplicate characters, where kk is the size of the Set. The size of the Set is upper bounded by the size of the string nn and the size of the charset/alphabet m.
*/

//Approach 2:Sliding window
 public int lengthOfLongestSubstring3(String s) {
     System.out.println(s);
     int[] chars = new int[128];
     
     int left = 0; 
     int right = 0;
     
     int res = 0;
     
     while(right < s.length()){
         char r = s.charAt(right);
         chars[r]++;
         
         while (chars[r] > 1){
             char l = s.charAt(left);
             chars[l]--;
             left++;
    //Test : System.out.println("Right :"+right +" left:" +left);
         }
/*
example:
abcabcbb
Right :3 left:1
Right :4 left:2
Right :5 left:3
Right :6 left:4
Right :6 left:5
Right :7 left:6
Right :7 left:7
*/
         res = Math.max(res,right - left + 1);
         right++;
     }
     
     return res;
 }
/*
Runtime: 2 ms, faster than 99.83% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 39.1 MB, less than 61.35% of Java online submissions for Longest Substring Without Repeating Characters.
*/
    
/*Complexity Analysis
Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by i and j.
Space complexity : O(min(m,n)). Same as the previous approach. We need O(k) space for the sliding window, where kk is the size of the Set. The size of the Set is upper bounded by the size of the string nn and the size of the charset/alphabet m.
*/
    
//Approach 3: Sliding Window Optimized  by using Map
    public int lengthOfLongestSubstring4(String s) {
    int n = s.length(),ans = 0;
    Map<Character,Integer> map = new HashMap<>();//current index of character
    //try to extend range [i,j]
    for(int j = 0, i = 0; j < n; j++){
        if(map.containsKey(s.charAt(j))){
            i = Math.max(map.get(s.charAt(j)),i); 
            //becausemap.put(s.charAt(j), j + 1);  no need to plus 1
        }
        ans = Math.max(ans,j-i+1);
        map.put(s.charAt(j), j + 1);
    }
        return ans;
 }
/*
Complexity Analysis
Time complexity : O(n)O. Index jj will iterate nn times.
Space complexity (HashMap) : O(min(m,n)). Same as the previous approach.
*/
    
/*
Commonly used tables are:
int[26] for Letters 'a' - 'z' or 'A' - 'Z'
int[128] for ASCII
int[256] for Extended ASCII
*/
   public int lengthOfLongestSubstring(String s) { 
       System.out.println(s);
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            System.out.print(" " + right +" " +index);
            if (index != null && index >= left && index < right) {
                left = index + 1;
            System.out.println(" left" +left);
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
   }
/*
    abcabcbb
 0 null 1 null 2 null 3 0 left1
 4 1 left2
 5 2 left3
 6 4 left5
 7 6 left7
bbbbb
 0 null 1 0 left1
 2 1 left2
 3 2 left3
 4 3 left4
pwwkew
 0 null 1 null 2 1 left2
 3 null 4 null 5 2 left3
*/
    
/*
Complexity Analysis
Time complexity : O(n)O. Index jj will iterate nn times.
Space complexity (Table): O(m). mm is the size of the charset.
*/
}

