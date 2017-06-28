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
		

	}
	
	public Node reverseKNode(Node head ,int k){
	    if(k < 2){
			return head;
		}
	    int count;
	    Node temp = head;
		
		return null;
	}
	
	public Node reverse(Node from,Node to){
		return null;
	}

}
