package leetcode;
/**
 * 将一个节点插入一个有序的环形链表中
 * @author Cherish
 *
 */
public class InsertNodeToRing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Node insertNode(Node head,int num){
		Node node = new Node(num);
		if(head == null){
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;
		while(cur != head){
			if(pre.value <= num && cur.value >= num){
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}

}
