package leetcode;

/**
 * n个数中，任意和为num的k个数
 * @author Cherish
 * 
 */
public class TheSumOfKIsNum {
	public static void main(String[] args) {
       int[] arr = {1,3,2,7,5,6,9};
       int k ;
       int sum ;
       int res = calculate(arr,0,2,3);
       System.out.println(res);
	}
	
	public static int findTheAnswer(int[] arr,int n,int k,int sum){
		int res = 0;
		
		return res;
		
	}

/**
 * 	
 * @param arr
 * @param index 开始下标
 * @param k
 * @param sum
 * @return 满足条件的有多少组数
 */
   public static int calculate(int[] arr,int index,int k ,int sum){
	   if(index>=arr.length)
		   return 0; 
	   if(0==k && 0==sum)
		   return 1;
	   if(0==k && 0 != sum)
		   return 0;
	   
	   return calculate(arr,index+1,k-1,sum-arr[index]) + calculate(arr,index+1,k,sum);
   }
}
