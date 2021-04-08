class twoSum {
    //Approach 1 :  Brute Force 
    public int[] twoSum(int[] nums, int target) {
         for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
                if(target == nums[i] + nums[j]){
                    return new int[] {i,j};
                }
            }
          }  
        throw new IllegalArgumentException("No two sum solution");
     }
    //complexity Analysis : Time complexity: O(n^2); Space complexity: O(1);
    
    //Approach 2 : Two-pass Hash Table
    public int[] twoSum2Hash2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i= 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] { i, map.get(complement)};
            }
        }
         throw new IllegalArgumentException("No two sum solution");
        }
   //reduce loop up time from O(n) to O(1) by trading space for speed 
   //complexity Analysis : Time complexity: O(n); Space complexity: O(n);

   //Approach 3 : One-pass Hash Table
    public int[] twoSum2Hash1(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] { i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
         throw new IllegalArgumentException("No two sum solution");
        } 
//reduce loop up time from O(n) to O(1) by trading space for speed 
   //complexity Analysis : Time complexity: O(n); Space complexity: O(n);
    }
