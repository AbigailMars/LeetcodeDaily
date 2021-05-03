
public class dietPlanPerformance {
	public int dietPlanPerformance1(int[] calories, int k, int lower, int upper) {
        int point = 0;
        int N = calories.length;
        int sum = 0;
        for(int i = 0; i <= N - k; i++){
            for(int j = 0; j < k;j++){
                sum = sum + calories[i+j];
            }
            if(sum < lower){
                point = point - 1;
            }else if(sum > upper){
                point = point + 1;
            }
            sum = 0;
        }
        return point;        
    }
	// Runtime: 1798 ms, faster than 7.48% of Java online submissions for Diet Plan Performance.
	//Memory Usage: 45.7 MB, less than 45.79% of Java online submissions for Diet Plan Performance.
	
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int start = 0;
        int end = 0;
        int points = 0;
        int calSum = 0;
        while (end < calories.length){
           calSum += calories[end];
            if(end - start + 1 == k){
                if(calSum < lower){
                    points--;
                }
                
                if(calSum > upper){
                   points++;
                }
                
                calSum -= calories[start];
                start++;
            }
            end++;
        }
        return points;
   }
}
