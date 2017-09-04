package leetcode;

import org.junit.Test;

/*
 * 最长上升子序列的长度
 * [1,4,2,5,3],5
 * 返回：3
 */
public class LongestIncreasingSubsequence {
	@Test
	public void getLIS() {
//		int[] A = {1,4,2,5,3};
//		int n  = 5;
		int[] A = {2,1,5,3,6,4,8,9,7};
		int n = 9;
		int[] dp = new int[n];
		dp[0] = 1;
		int res = dp[0];
		for(int i = 1 ; i < n ; i++){   //表示以A[i]结尾的最长上升子序列
		   int max = 0 ; 
		   for(int j = 0 ; j < i ; j++){
			   if(A[j]<A[i]&&dp[j]>max){
				   max = dp[j];
			   }
			   dp[i] = max+1;
		   }
		}
		for(int i =10 ; i < dp.length ; i++){
			if(dp[i] > res)
				res = dp[i];
		}
		System.out.println(res);
    }
}
