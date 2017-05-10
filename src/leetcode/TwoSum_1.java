package leetcode;
/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

   You may assume that each input would have exactly one solution, and you may not use the same element twice.

   Example:
   Given nums = [2, 7, 11, 15], target = 9,

   Because nums[0] + nums[1] = 2 + 7 = 9,
   return [0, 1].
 * */
public class TwoSum_1 {

	public static void main(String[] args) {
       int[] a = new TwoSum_1().twoSum(new int[]{1,2,5},6);
       StringBuilder sb = new StringBuilder("[");
       for(int i = 0 ; i < a.length ;i ++){
    	   sb.append(a[i]);
    	   if(i == a.length-1)
    		   break;
    	   sb.append(",");
       }
       sb.append("]");
       System.out.println(sb);
	}
	
	public int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i++){
            for(int j =  i+1; j < nums.length ; j++){
                if(target == nums[i]+nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

}
