package leetcode;

public class LinkedListDivide {

	public static void main(String[] args) {    //给定一个链表，将它划分为两个个部分 9->0->4->5->1,pivot = 3
        Node node5 = new Node(1,null);
        Node node4 = new Node(5,node5);
        Node node3 = new Node(4,node4);
        Node node2 = new Node(0,node3);
        Node node1 = new Node(9,node2);
        
        int pivot = 3;
        Node head = new LinkedListDivide().LinkedListDivide(node1, pivot);
        while(head != null){
        	System.out.println(head.value);
        	head = head.next;
        }
        
	}

	public Node LinkedListDivide(Node head,int pivot){
	   Node uphead = null;
	   Node uptail = null;
	   Node downhead = null;
	   Node downtail = null;
	   Node move = null;
	   move = head;         //这一块自己处理的不好，居然想着去new一个新节点然后赋值，直接把节点摘下来加到链表上就好了
	   while(move != null){
		  move = move.next;
		  if(head.value<pivot){        //放上半部分
			  if(uphead==null){        //上半部分比较小
				  uphead = head;
				  uptail = head;
			  }else{
				  head.next = uphead.next;
				  uphead.next = head;
			  }
		  }else{
			  if(downhead == null){
				  downhead = head;
				  downhead.next = downtail;
			  }else{
				  head.next = downhead.next;
				  downhead.next = head;
			  }
		  }
		  if(move==null){   //之前没写好，这样避免一下空指针把
			  break;
		  }
		  head = move;
	   }
	   head.next = uphead;
	   uptail.next = downhead;
	  return head; 
	}

}
