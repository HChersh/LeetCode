package leetcode;

import java.util.Scanner;

public class tiaotaijie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int temp = 0;
			int a = 1;
			int b = 1;
			while (n-- > 0) {
				temp = a;
				a = b;
				b = temp + b;
			}
			System.out.println(a);
		}
	}
	 public static int count_1(int n){  //非递归方式
			int temp = 0;
			int a = 1;
			int b = 1;
			while (n-- > 0) {
				temp = a;
				a = b;
				b = temp + b;
			}
	        return a;
	    }
	    public static int count_2(int n){  //递归的方式
	        if(n<1)
	            return 0;
	        if(n<=2){
	            return n;
	        }
	        return count_2(n-1)+count_2(n-2);
	    }

}
