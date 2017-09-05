package leetcode;

import org.junit.Test;

/**
 * 最优秀编辑练习
 * 
 * @author cherish
 *         对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 *         给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 *         "abc",3,"adc",3,5,3,100 返回：8
 */
public class MinCost {
	@Test
	public void findMinCost() {
		String A = "abc";
		int n = 3;
		String B = "adc";
		int m = 3;
		int c0 = 5;     //插入
		int c1 = 2;     //删除
		int c2 = 2;   //修改
		int[][] dp = new int[n+1][m+1];
		dp[0][0] = 0;   //空串替换为空串
		for(int i =  1 ; i < dp.length ; i++){
			dp[i][0] = c1*i;
		}
		for(int j = 1 ; j < dp[0].length ; j++){
			dp[0][j] = c0*j;
		}
		for(int i  = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[i].length ; j++){
				int min = 0;
			    min = Math.min(dp[i-1][j-1]+c2, Math.min(dp[i-1][j]+c1, dp[i][j-1]+c0));   //不考虑i和j位的字符相等的情况
			    if(A.charAt(i-1)==B.charAt(j-1)){
			    	min = Math.min(min, dp[i-1][j-1]);
			    }
			    dp[i][j] = min;
			}
		}
		for(int i = 0 ;i < dp.length ; i++){
			for(int j = 0 ; j < dp[i].length ;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(dp[n][m]);
		
	}
}
