package leetcode;
/**
 * 判断两个链表是否相交，如果相交则返回相交后的第一个节点
 * 问题可以分为一下三个子问题：
 * 1.两个链表是否各自为环，两个链表一个为环，一个不为环，则肯定不相交
 * 2.若两个链表都不为环判断是否相交
 * 3.若两个链表都为环判断是否相交
 *
 */
public class LinkedListCross {

	public static void main(String[] args) {
		//环形链表node1 1->2->4->3->5->3
		Node node5 = new Node(5);
		Node node3 = new Node(3,node5);
		Node node4 = new Node(4,node3);
		Node node2 = new Node(2,node4);
		Node node1 = new Node(1,node2);
	    node5.next = node3;
	    Node result = isRing(node1);
	    System.out.println(result.value);
	    System.out.println((result==null?0:1)^0);
	}
	/**
	 * 判断一个链表是否为环
	 * @param head
	 * @return Node表示如果为环，返回环的第一个节点，返回null表示链表中没有环
	 * 
	 */
	
	public static Node isRing(Node head){
		if(null == head || null == head.next || null == head.next.next){
			return null;
		}
		Node fast = head.next.next;                 //每次走两步
		Node low = head.next;                       //每次走一步
		while(fast != low){
			if(null == fast || null == low){
				return null;
			}
			fast = fast.next.next;
			low  = low.next;
		}
		fast = head;                                //在判断有环之后，快指针指向头部，与慢指针同时单步移动，下次相交就是首个相交节点
		while(fast != low){
			fast = fast.next;
			low = low.next;
		}
		return fast;
	}
	/**
	 * 判断两个链表是否相交
	 * @param head1
	 * @param head2
	 * @return Node 不相交返回null,相交返回相交节点
	 */
	public static Node isCross(Node head1,Node head2){                  //判断两个链表是否相交
		Node result1 = isRing(head1);
		Node result2 = isRing(head2);
		if((result1==null&&result2!=null) || (result2==null&&result1!=null)){  //当两个链表，一个为环，一个不为环的时候，肯定不会相交
			return null;
		}
		
		if(result1==null && result2==null){                    //两个链表都不为环  ,下面比较链表长短的方式应该熟练记住
			Node temp = head1;
			int length = 0 ;                                  
			while(temp != null){                             
				temp = temp.next;
				length++;
			}
		    temp = head2;
			while(temp != null){
				temp = temp.next;
				length--;
			}
			temp = length>0?head1 : head2;           //求出较长的一条链表
			Node tmp = temp==head1?head2 : head1;   //tmp 指向另一条链表
			length = Math.abs(length);
			while(length > 0){                      //长链表先走length步
				temp = temp.next;
				length--;
			}
			while(tmp!=null&&temp!=null){
				if(tmp == temp){
					return tmp;
				}
				tmp = tmp.next;
				temp = temp.next;
			}
			return null;                                     //其中一个链表走到尾，说明没有交点
		}else{                                               //两个链表都为环,result1和result2都不为null
		  if(result1 == result2){                            //入环节点相同，问题和两个非环节点类似，终止节点由null，变为result即可
			  Node temp = head1 ;
			  int length = 0 ;
			  while(temp != result1){
				  temp = temp.next;
				  length ++;
			  }
			  temp = head2;
			  while(temp != result2){
				  temp = temp.next;
				  length --;
			  }
			  temp = length>0? head1 : head2;
			  Node tmp = temp==head1?head2 : head1;
			  length = Math.abs(length);
			  while(length>0){
				  temp = temp.next;
			  }
			  while(temp!=result1 && tmp!=result2){
				  if(temp == tmp){
					  return tmp;
				  }
				  temp = temp.next;
				  tmp = temp.next;
			  }
			  return result1;
		  }else{                                              //两个环形链表没有共同的交点
			  Node temp = result1.next;
			  while(temp != result1){
				  if(temp == result2){                        //result1和result2在同一个环上，任意返回一个节点就行
					  return result1;
				  }
			  }
			  return null;                                    //否则是两个不相交的环，返回一个空节点
		  }
		}
		
	}
	


}
