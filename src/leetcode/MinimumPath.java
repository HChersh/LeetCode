package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class MinimumPath {

	@Test
	public void getMin() {
//		int[][] map = {{1,2,3},{1,1,1}};
//		int n = 2;
//		int m = 3;
		int n = 4;
		int m = 4;
		int[][] map = {{613,0,93,463},{101,369,112,255},{42,67,86,543},{485,452,393,461}};
	    int[][] dp = new int[4][4];
	    dp[0][0] = map[0][0];
	    for(int i = 1 ; i < n; i++){
	    	dp[i][0] = dp[i-1][0] + map[i][0];
	    }
	    for(int j = 1 ; j < m ; j++){
	    	dp[0][j] = dp[0][j-1] + map[0][j];
	    }
	    for(int i = 1 ; i < n ; i ++){
	    	for( int j = 1 ; j < m ; j++){
	    		dp[i][j] = dp[i-1][j]<dp[i][j-1] ? dp[i-1][j]+map[i][j] : dp[i][j-1]+map[i][j];
	    	}
	    }
	    System.out.println(dp[n-1][m-1]);
	}
}
