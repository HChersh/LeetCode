package leetcode;

import java.util.LinkedList;

/**
 * 二进制相关的问题
 * 1.求出n的二进制中1的个数
 * 2.求出1到n的二进制表示的1的个数
 * @author cherish
 *
 */
public class BinaryRelated {

	public static void main(String[] args) {
       int n = 8;
       int temp;
       LinkedList<Integer> list = new LinkedList<Integer>();
//       System.out.println( Integer.toBinaryString(n));
//       System.out.println(Integer.bitCount(n));
         while(n != 1){
        	temp = n % 2;
        	n = n/2;
        	list.addFirst(temp);
         }
         list.addFirst(1);
         while(list.size() > 0){
        	 System.out.print(list.getFirst());
        	 list.removeFirst();
         }
       
	}

}
