package leetcode;

public class PalindromicLinkedList { // 鍒ゆ柇閾捐〃鏄惁涓轰竴涓洖鏂囧簭鍒�	
	/*
	 * 鐢ㄦ爤缁撴瀯瀹炵幇姣旇緝鐨勭畝鍗曪紝杩欓噷鎴戜滑闇�鏃堕棿澶嶆潅搴﹁揪鍒癘(N),棰濆搴︾┖闂村鏉傚害杈惧埌O(1)
	 */
	public static boolean isPalindromel(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node left;
		Node right;
		Node temp = head;
//        int length = 0;
//        while(temp != null){      //閫氳繃渚垮埄閾捐〃寰楀埌闀垮害鏉ユ壘鍒颁腑闂磋妭鐐圭湡鏄瀮鍦撅紒锛侊紒
//        	temp = temp.next;
//        	length++;
//        }
        Node n1 = head;  Node n2 = head;
        while(n2.next != null &&n2.next.next !=null ){   //鏌ユ壘涓棿鑺傜偣
           n1 = n1.next;        //涓棿鑺傜偣
           n2 = n2.next.next;   //灏鹃儴鑺傜偣
        }
        
        
		return true;
	}

	public static void main(String[] args) {
       Node node5 = new Node(1,null);   //1->2->3->2->1
       Node node4 = new Node(2,node5);
       Node node3 = new Node(3,node4);
       Node node2 = new Node(2,node3);
       Node node1 = new Node(1,node2);
       System.out.println(isPalindromel(node1));
	}
}
