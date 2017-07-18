package leetcode;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 * @author cherish
 *
 */
public class FindMaxMatrix {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] map = {{1,0,1,1},
    		          {1,1,1,1},
    		          {1,1,1,0}};
       System.out.println();
	}
	
	public static int maxRecSize(int[][] map){   //我们首先采取时间复杂度为O(m*n)的方法
		int maxSize = 0;
		int[] hight = new int[map[0].length];
		if(map==null||map.length==0||map[0].length==0){
			return 0;
		}
		for(int i = 0 ; i < map.length ; i++){   //用每一列作底去计算矩阵最小的面积
			for(int j = 0 ;i < map[0].length ; j++){
				hight[j] = hight[j] == 0 ? 0 : hight[j]+1;
				maxSize = Math.max(maxSize, maxRecFromBottom(hight));
			}
		}
		return maxSize;
	}
	public static int maxRecFromBottom(int[] hight){
		Stack<Integer> stack = new Stack<Integer>();
		int maxSize = 0;
		for(int i = 0 ; i < hight.length ; i++){
			
		}
		return maxSize;
	}

}
