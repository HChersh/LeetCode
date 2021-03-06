package leetcode;

public class PalindromicLinkedList { // 判断链表是否为一个回文序列
	/*
	 * 用栈结构实现比较的简单，这里我们需要时间复杂度达到O(N),额外度空间复杂度达到O(1)
	 */
	public static boolean isPalindromel(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node left;
		Node right;
		Node temp = head;
		boolean flag = true;
//        int length = 0;
//        while(temp != null){      //通过便利链表得到长度来找到中间节点真是垃圾！！！
//        	temp = temp.next;
//        	length++;
//        }
        Node n1 = head;  Node n2 = head;
        while(n2.next != null &&n2.next.next !=null ){   //查找中间节点
           n1 = n1.next;        //中间节点
           n2 = n2.next.next;   //尾部节点
        }
        right = n1.next;        //指向右侧的第一个节点
        while(right != null){
        	if(flag){                         //第一次，将反转后的尾节点的next指向null
        		n1.next = null;
        		flag = false;
        	}
        	temp = right;
        	right = right.next;
        	temp.next = n1;
        	n1 = temp;
        }
        left = head;    //左右头赋值
        right = n1; 
        while(left.next != null){
        	if(left.value != right.value)
        		return false;
        	left = left.next;
        	right = right.next;
        }
        return true;
	}

	public static void main(String[] args) {
       Node node5 = new Node(1,null);    //1->2->3->3->2->1
       Node node4 = new Node(2,node5);
       Node node3 = new Node(3,node4);
       Node node2 = new Node(3,node3);
       Node node1 = new Node(2,node2);
       Node node0 = new Node(1,node1);
       System.out.println(isPalindromel(node0));
	}
}
