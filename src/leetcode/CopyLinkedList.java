package leetcode;

import java.util.HashMap;

public class CopyLinkedList {

	public static void main(String[] args) {
		Nodes head = null; //代表含有随机指针的链表，这里就不初始化了
		HashMap<Nodes, Nodes> map = new HashMap<Nodes,Nodes>();
        Nodes temp = head;
        while(temp != null){
        	map.put(temp, new Nodes(temp.value));
        }
        temp = head;
        while(temp != null){
        	map.get(temp).next = map.get(temp.next);
        	map.get(temp).random = map.get(temp.random);
        	temp = (Nodes) temp.next;
        }
	}

}
