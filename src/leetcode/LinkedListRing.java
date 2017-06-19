package leetcode;

public class LinkedListRing {    // 环形链表测试用例
	public static Node list1;
	public static Node list2;
	public static Node list3;

	public static Node testList1() {  //正常的两个节点以上的环形链表
	  Node node7 = new Node(7,null);
	  Node node6 = new Node(6,node7);
	  Node node5 = new Node(5,node6);
	  Node node4 = new Node(4,node5);
	  Node node3 = new Node(3,node4);
	  Node node2 = new Node(2,node3);
	  list1 = new Node(1,node2);
	  node7.next = list1;
      return list1;
	}

	public static Node testList2() {  //只有一个节点的环形链表
      list2 = new Node(1,list2);
      return list2;
	}

	public static Node testList3() { //返回一个空指针
       list3 = null;
       return list3;
	}

}
