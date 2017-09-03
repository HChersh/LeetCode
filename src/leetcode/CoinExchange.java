package leetcode;

public class CoinExchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] penny = {1,2,4};
		int aim = 3;
        System.out.println(charge(penny,0,aim));
        System.out.println(charge_2(penny,aim));
	}
	
	 public static int charge_2(int[] penny,int aim){  //动态规划非递归方式
		 int[] res = new int[aim+1];
		 res[0] = 1;
		 for(int i = 0 ; i < penny.length ; i++){
			 for(int j = penny[i] ; j <= aim ; j++){
				 res[j] += res[j-penny[i]];
			 }
		 }
		 return res[aim];
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
