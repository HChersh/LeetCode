package leetcode;
/**
 * 将单链表的每k个节点之间逆序：
 * 给定一个单链表的头节点head,实现一个调整单链表的函数，使得每K个节点之间逆序，
 * 如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如：
 * 链表：1->2->3->4->5->6->7->8->null,K=3
 * 调整后为：3->2->1->6->5->4->7->8->null。其中7、8不调整，因为不够一组 
 *
 * @author Cherish
 *
 */
public class ReverseKthNodes {

	public static void main(String[] args) {
		Node node8 = new Node(8,null);     //1->2->3->4->5->6->7->8->null,K=3
		Node node7 = new Node(7,node8);
		Node node6 = new Node(6,node7);
		Node node5 = new Node(5,node6);
		Node node4 = new Node(4,node5);
		Node node3 = new Node(3,node4);
		Node node2 = new Node(2,node3);
		Node node1 = new Node(1,node2);
		Node result = new ReverseKthNodes().reverseKNode(node1, 3);
		while(result != null){
			System.out.println(result.value);
			result = result.next;
		}

	}
	
	public Node reverseKNode(Node head ,int k){
		Node result = null;     //用来存翻转后链表的头节点
		Node next = null;       //用来存储每一小段的头节点
		Node nexthead = null;       //用来在翻转前存下一小段节点的头部
		Node from = head;
		Node to = head;
	    if(k < 2){
			return head;
		}
	    int count = 0;
	    while(to.next != null){
	    	from = head;
	   	    to = head;
	    	while(count < k && to.next!=null){
		    	to = to.next;
		    	count++;
		    }
	    	nexthead = to.next;
		    next = reverse(from,to,count);
		    if(from == head){
		    	result = next;
		    }
		    from.next = nexthead;
		    
	    }
		
		return result;
	}
	
	public Node reverse(Node from,Node to,int count){           //返回每一小段翻转后的头
		if(count<2){         //长度不够，直接返回头节点
			return from;
		}
		Node pre = null;
		Node mov = from;
		Node next = from.next;
		while(mov.next != null){
			mov.next = pre;
			pre = mov;
			mov = next;
			next = next.next;
		}
		mov.next = pre;
		return mov;       
	}

}
