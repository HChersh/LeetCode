package leetcode;
/**
 * 根据数组生成对应的链表
 * @author Cherish
 *
 */
public class LinkedListFactory {
   public static Node getLinkedList(int[] arr){
	  Node next = null;
	  Node temp = null;
	  for(int i = arr.length ; i>0 ;i--){
		  temp = new Node(arr[i-1],next);
		  next = temp;
	  }
	  return temp; 
   }
}
