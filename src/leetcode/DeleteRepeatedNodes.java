package leetcode;

import java.util.HashSet;

/**
 * 给定一个无序单链表的头节点head,删除其中值重复出现的节点
 * 例如：1->2->3->3->4->2->1->null,删除重复的节点之后为1->2->3->4->null 
 * 请按以下要求实现两种方法：
 * 1.如果链表长度为N,时间复杂度达到O(n) 
 * 2.额外的空间复杂度为O(1)
 * @author Cherish
 * 
 */
public class DeleteRepeatedNodes {
	public static void main(String[] args) {
       int[] arr = {1,2,3,3,4,2,1};
       Node head = LinkedListFactory.getLinkedList(arr);
       head = new DeleteRepeatedNodes().deleteUseHashSet(head);
       System.out.println("测试第一个方法");
       while(head != null){
    	   System.out.print(head.value+" ");
    	   head = head.next;
       }
       System.out.println();
       System.out.println("测试第二个方法");
       Node head2 = LinkedListFactory.getLinkedList(arr);
       head2 = new DeleteRepeatedNodes().deleteUseSelectSort(head2);
       while(head2 != null){
    	   System.out.print(head2.value+" ");
    	   head2 = head2.next;
       }
       System.out.println();
	}
	
	public Node deleteUseHashSet(Node head){      // 1.如果链表长度为N,使用hashSet时间复杂度达到O(n)
		if(head == null){
			return head;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		set.add(pre.value);
		while(cur != null){
		   if(set.contains(cur.value)){
			   pre.next = cur.next;
		   }else{
			   set.add(cur.value);
			   pre = cur;
		   }
		   cur = cur.next;
		}
		return head;
	}
	
	public Node deleteUseSelectSort(Node head){    //2.额外的空间复杂度为O(1)使用类似选择排序的方法，时间复杂度O(N*N),空间复杂度O(1)
//		Node next = head;
//		Node cur = next.next;
//		Node pre = next;
		for(Node next = head ; next!=null;next = next.next){
			Node pre = next;
			for(Node cur = next.next ; cur != null ; cur = cur.next){
				if(cur.value == next.value){
					pre.next = cur.next;          //这一步只是删除了cur节点，pre是没有变的
				}else{
					pre = cur;
				}
			}
		}
		return head;
	}
}
