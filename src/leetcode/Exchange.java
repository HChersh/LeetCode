package leetcode;
/**
 * 有数组penny，penny中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * @author cherish
 */
public class Exchange {

	public static void main(String[] args) {
		int[] penny = {1,2,4};
		int n = 3;
		int aim = 3;
        System.out.println(f1(penny,n,0,aim));
	}
	public static  int f1(int[] penny,int n , int index,int aim){  //暴力搜索法
		if(penny == null || penny.length == 0 || aim<0){
			return 0;
		}
		int res = 0;
		if(index == penny.length-1){
			res = aim==0 ? 1 : 0;
		}else{
		    for(int i = 0 ; penny[index]*i<aim;i++){
		    	res += f1(penny,n,index++,aim-penny[index]*i);
		    }
		}
		return res;
	}

}
