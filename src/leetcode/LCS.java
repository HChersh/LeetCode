package leetcode;

import org.junit.Test;

/**
 * 寻找字符串的最长公共子序列 
 * 	测试样例： "1A2C3D4B56",10,"B1D23CA45B6A",12 
 * 	返回：6
 * 
 * @author cherish
 *
 */
public class LCS {
	@Test
	public void findLCS() {
//		String A = "1A2C3D4B56";
//		int n = 10;
//		String B = "B1D23CA45B6A";
//		int m = 12;
		String A = "rsymsknwbiapzhuoeyhjubogitoqfkswhbqhwqzyjuvdlzjlhlaubecnkzgvurdsuvqghpjazgxvue";
		int n = 78;
		String B = "sclzdzbtrrkdybusjyjrszzqaebkpdtqnqadndvkenqirqqsplmceuuzhukcxxnkcyyvucqjlkysfarx"
				+ "kulpayvtwfmfaqpikzdslpklomafvtesecxygahwnyljldutzsoywiwkugerfbfefcqfvcrzcvbevufzbkbhfeshhdasqo";
		int m = 174;
		int[][] dp = new int[n][m];
		for(int i = 0 ; i < n ; i++){      //初始化第一列
			if(B.charAt(0)==A.charAt(i)){
				dp[i][0] = 1;
			}
		}
		for(int j = 0 ; j < m ; j++){
			if(A.charAt(0)==B.charAt(j)){  //初始化第一行
				dp[0][j] = 1;
			}
		}
		for(int i = 1; i < n ; i++){
			for(int j = 1; j < m ; j++){
			   int temp = Math.max(dp[i-1][j], dp[i][j-1]);
			   if(A.charAt(i)==B.charAt(j)){
				   dp[i][j] = Math.max(temp, dp[i-1][j-1]+1);
			   }else{
				   dp[i][j] = temp;
			   }
			}
		}
		System.out.println(dp[n-1][m-1]);
		
	}
}
