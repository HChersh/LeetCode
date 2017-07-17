package leetcode;

import java.util.LinkedList;

public class FindWindowMaxNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr = {4,3,5,4,3,3,6,7};
       int w = 3;
       int[] result = getMaxNum(arr,w);
       for(int i = 0 ; i < result.length ; i++){
    	   System.out.println(result[i]);
       }
	}
	/**
	 * 时间复杂度为O(n)
	 * @param arr 用来遍历的窗口数组
	 * @param w  窗口的大小
	 * @return  返回每个窗口的最大值
	 */
	public static int[] getMaxNum(int[] arr ,int w){
		if(arr == null || w<1 || arr.length<w)
			return null;
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int index = 0;
		int[] result = new int[arr.length-w+1];//用下标来记录，方便我们之后计算头节点是否需要出去
		for(int i = 0 ;i < arr.length ; i++){//先把不符合要求的弹出去然后，把当前数值加进去，然后再看头部是否需要移除
			while(! qmax.isEmpty() && qmax.peekLast()<=arr[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst() == i-w){//不需要<，因为等于就已经弹出来
			  qmax.pollFirst();
			}
			if(i >= w-1){    //前w个数字只需要输出一次的
			   result[index++] = arr[qmax.peekFirst()]; 	
			}
		}
		return result;
	}

}
