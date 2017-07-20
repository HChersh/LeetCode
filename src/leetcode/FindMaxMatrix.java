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
      Stack<Integer> stack = new Stack<>();
      int maxRecSize = maxRecSize(map);
      System.out.println(maxRecSize);
	}
	
	public static int maxRecSize(int[][] map){   //我们首先采取时间复杂度为O(m*n)的方法
		int maxSize = 0;
		int[] hight = new int[map[0].length];
		if(map==null||map.length==0||map[0].length==0){
			return 0;
		}
		for(int i = 0 ; i < map.length ; i++){   //用每一列作底去计算矩阵最小的面积
			for(int j = 0 ;j < map[0].length ; j++){
				hight[j] = map[i][j] == 0 ? 0 :hight[j]+1;
				maxSize = Math.max(maxSize, maxRecFromBottom(hight));
			}
		}
		return maxSize;
	}
	public static int maxRecFromBottom(int[] hight){
		Stack<Integer> stack = new Stack<Integer>();
		int maxSize = 0;
		for(int i = 0 ; i < hight.length ; i++){
			while(!stack.isEmpty() && hight[i]<=hight[stack.peek()]){ //向左扩散到k+1,向右扩散到i-1
				int j = stack.pop();
				int k = stack.isEmpty() == true? -1 : stack.peek();
				int area = hight[j]*(i-k-1);
				maxSize = Math.max(area, maxSize);
			}
			stack.push(i);
		}
		while(!stack.isEmpty()){                              //还需要清理最后剩在栈中的元素
			int j = stack.pop();
			int k = stack.isEmpty() == true? -1 : stack.peek();
			int area = hight[j]*(hight.length-k-1);           //因为已经可以到达最右边了
			maxSize = Math.max(area, maxSize);
		}
	
		return maxSize;
	}

}
