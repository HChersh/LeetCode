package leetcode;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * 给定数组arr和整数num,共返回多少个子数组满足如下情况：
 * max(arr[i..j])-min(arr[i..j] <= num
 * max(arr[i..j])表示子数组中的最大值，min(arr[i..j])表示子数组中的最小值
 * @author cherish
 *
 */
public class TheNumOfMaxSubMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {2,3,4,5,6,1,2,5};
        int res = 0;   //满足条件的子数组个数和
        int i = 0;   //维持arr[i..j]中的i
        int j = 0;   //维持arr[i..j]中的j
        int num = 1;
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();

        for( ; i < arr.length ; i++){
        	for( ; j < arr.length ;j++ ){
        		while(!qmin.isEmpty() && qmin.peekLast()>=arr[j]){     //维持窗口最小值
        			qmin.pollLast();
        		}
        		qmin.addLast(j);
        		while(!qmax.isEmpty() && qmax.peekLast()<=arr[j]){      //维持窗口最大值
        			qmax.pollLast();
        		}
        		qmax.addLast(j);
        		if((qmax.peekFirst() - qmin.peekFirst()) > num){        //说明右移多了，先中断
        			break;
        		}
        	}
    		if(qmin.peekFirst() == i){          //头部挪动到i了，需要弹出头部节点
    			qmin.pollFirst();
    		}
            if(qmax.peekFirst() == i){
            	qmax.pollFirst();
            }
            res += j-i;
        }
        System.out.println(res);
	}

}
