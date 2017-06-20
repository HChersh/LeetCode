package leetcode;

import java.util.logging.Logger;

public class JosephRing {
	public Node josePh(Node head, int m) {
		if (null == head || head == head.next || 1 == m) {
			return head;
		}
		Node temp = head;
		while (temp.next.next != temp) {
			int count = m;
			if (count > 2) {
				temp = temp.next;
				count--;
			}
			System.out.println(temp.next.value);
			temp.next = temp.next.next;
			temp = temp.next;
		}

		return m == 2 ? temp : temp.next; // 当m = 2 时需要特殊处理一下
	}

	public Node optimizeJoseph(Node head, int m) {
		/*
		 *    1) B=(A-1)%i+1   //A表示报数，B表示编号，i为链表的当前个数（等式表示报数与编号之间的关系）
		 *    2）f(i) = [f(i-1)+S-1]%i+1   //S为当前删除节点的编号,f(i)表示i个节点中最后剩下节点的标号
		 *    3）由S = （m-1)%i带入不等式，得到f(i)与f(i-1)的递归式，便可以算出最后的结果
		 *    4）f(i) = [f(i-1)+m-1]%i+1
		 *    
		 * */
		if (null == head || head == head.next || 1 == m) {
			return head;
		}
		int i = 1;       //至少都有两个节点if
		Node temp = head;
		for(;temp.next.next != temp;temp = temp.next)   //计算环的大小
			i += 1;;
		int pos = getPos(i,m);	
        for(temp=head;pos>1;pos--,temp = temp.next);
		return temp;
	}
	public int getPos(int i , int m){
		if( 1 == i){
			return 1;
		}
		return (getPos(i-1,m)+m-1)%i + 1;
	}

}
