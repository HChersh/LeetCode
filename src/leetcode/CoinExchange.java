package leetcode;

public class CoinExchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] penny = {1,2,4};
		int aim = 3;
        System.out.println(charge(penny,0,aim));
	}
	 public static int charge(int[] penny, int index, int aim){  //递归的方式
	       int res = 0;
	       if(penny == null || aim < 0 ){
	           return 0;
	       }
	       if(index == penny.length){
	           if(aim == 0){
	               return 1;
	           }else{
	               return 0;
	           }
	       }
	       for(int i = 0 ; penny[index]*i <= aim ; i++){
	           res += charge(penny,index+1,aim-penny[index]*i);
	       }
	       return res;
	    }

}
