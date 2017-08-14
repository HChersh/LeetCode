package leetcode;

import java.util.Arrays;

/*
 * 给定一个无序数组，包含正数、负数和0，
 * 要求从中找出3个数的乘积，使得乘积最大，
 * 要求时间复杂度：O(n)，空间复杂度：O(1) 
 * 输入例子1: 3 4 1 2
 * 输出例子1: 24
 */
public class FindMaxMultiplication {
	public static void main(String[] args) {
		int[] a = { 3, 4, 1, 2 };
		new FindMaxMultiplication().quickSort(a, 0, 3);
		for(int i = 0 ;i < a.length; i++){
			System.out.println(a[i]);
		}
		
	}
   public void quickSort(int[] arr,int from ,int to){
	   if(from > to )
		   return;
	   int index = partition(arr,from,to);
	   if(index == 2){
		   return;
	   }
	   quickSort(arr,from,index-1);
	   quickSort(arr,index+1,to);
   }
   public int partition(int[] arr ,int from ,int to){
	 int basis = from;
	 int temp = from +1;
	 while(temp < to + 1){
		 if(arr[temp]>arr[from]){
			 basis++;
			 int swap = arr[basis];
			 arr[basis] = arr[temp];
			 arr[temp] = swap;
		 }
		temp++;
     }
	 int swap = arr[from];
	 arr[from] = arr[basis];
	 arr[basis] = swap;
	 return basis;
   }
}
