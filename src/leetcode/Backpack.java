package leetcode;

import org.junit.Test;

/**
 * 0,1背包问题 [1,2,3],[1,2,3],3,6 返回：6
 * 
 * @author cherish
 *
 */
public class Backpack {
	@Test
	public void maxValue() {
		// int[] w = {1,2,3};
		// int[] v = {1,2,3};
		// int n = 3;
		// int cap = 6;
		int[] w = { 17, 34, 38, 42, 36 };
		int[] v = { 335, 406, 160, 452, 311 };
		int n = 5;
		int cap = 90;
		int[][] dp = new int[n + 1][cap + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < cap + 1; j++) {
				if (j < w[i-1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i-1]] + v[i-1]);
				}
			}
		}
		System.out.println(dp[n][cap]);
	}
}
