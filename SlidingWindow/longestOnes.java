
public class longestOnes{
	public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int flipNum = 0;
        int maxLength = 0;
        while(end < nums.length){
            if(nums[end] == 0){                
                if(flipNum == k){
                    if(nums[start++] == 0){
                        flipNum--;
                    }
                }else{
                      flipNum++;
                      end++;  
                    }               
            }else{
                end++;
            }
            if(end - start  > maxLength)
                maxLength = end - start;
        }
        return maxLength;
    }
	
	//Runtime: 2 ms, faster than 99.74% of Java online submissions for Max Consecutive Ones III.
	//Memory Usage: 40.2 MB, less than 58.66% of Java online submissions for Max Consecutive Ones III.
	
	  public int longestOnes1 (int[] A, int K) {
		    int left = 0, right;
		    for (right = 0; right < A.length; right++) {
		      // If we included a zero in the window we reduce the value of K.
		      // Since K is the maximum zeros allowed in a window.
		      if (A[right] == 0) K--;
		      // A negative K denotes we have consumed all allowed flips and window has
		      // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
		      if (K < 0) {
		        // If the left element to be thrown out is zero we increase K.
		        if (A[left] == 0) K++;
		        left++;
		      }
		    }
		    return right - left;
		  }

	 //Time Complexity: O(N), where N is the number of elements in the array. In worst case we might end up 
	   //visiting every element of array twice, once by left pointer and once by right pointer.
    //Space Complexity: O(1). We do not use any extra space.
}
