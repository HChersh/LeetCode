package leetcode;
/**
 * 单链表选择排序
 * 给定一个无序单链表的头节点head，实现单链表的选择排序
 * 要求：额外空间复杂度为O(1)
 * @author Cherish
 *
 */
public class LinkedListSelectSort {

	public static void main(String[] args) {
       int[] arr = {4,2,3,1,7,9};
       Node head = LinkedListFactory.getLinkedList(arr);
       Node result = new Node();//用来存储排序后的节点
       Node tail = result;
       Node cur = head;
       while(cur != null){
    	   Node smallestPre = getSmallestPreNode(head);
    	   if(smallestPre == null){
    		   tail.next = cur;
    		   tail = cur;
    		   cur = cur.next;
    	   }else{
    		   tail.next = smallestPre.next;
    		   smallestPre.next = smallestPre.next.next;
    	   }
       }
	}
	
    public static Node getSmallestPreNode(Node head){  //返回为排序链表中最小节点的前一个节点
    	Node smallPre = null;
    	Node small = head;
    	Node cur = head.next;
    	Node pre = head;
    	while(cur != null){
    	   if(cur.value < small.value){
    		   small = cur;
    		   smallPre = pre;
    		   pre = pre.next;
    		   cur = cur.next;
    	   }
    	}
    	return smallPre;
    }
}
