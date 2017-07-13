package leetcode;

/**
 * 合并两个有序的单链表，例如： 0->2->3->7->null 1->3->5->7->9->null
 * 合并后的链表为：0->1->2->3->3->5->7->7->9->null
 * @author Cherish
 */
public class CombineTwoOrderedLinkedList {
	public static void main(String[] args) {
       int[] arr1 = {0,2,3,7};
       int[] arr2 = {1,3,5,7,9};
       Node head1 = LinkedListFactory.getLinkedList(arr1);
       Node head2 = LinkedListFactory.getLinkedList(arr2);
       Node result = combine(head1,head2);
       Node cur = result;
       while(cur != null){
    	   System.out.print(cur.value+" ");
    	   cur = cur.next;
       }
	}
	
	public static Node combine(Node head1,Node head2){
		if(head1 == null || head2 == null){
			return head1 == null ? head2 : head1;
		}
		Node head = null;
		Node cur1 = null;
		Node cur2 = null;
		Node pre = null;
		Node temp = null;
		if(head1.value < head2.value){   //初始化链表，保证head,cur1,pre都指向头节点偏小的链表上
			head = head1;
			cur2 = head2;
		}else{
			head = head2;
			cur2 = head1;
		}
		pre = head;
		cur1 = head.next;
		
		while(cur1 != null && cur2 != null){
           if(cur2.value <= cur1.value){
        	   temp = cur2.next;
        	   pre.next = cur2;
        	   cur2.next = cur1;
        	   pre = cur2;
        	   cur2 = temp;
           }else{
        	   pre = cur1;
        	   cur1 = cur1.next;
           }
		}
		if(cur1 == null){
			pre.next = cur2;
		}else{
			pre.next = cur1;
		}
		return head;
	}
}
