package leetcode;

import java.util.Stack;

public class TowListAdd {

	public static void main(String[] args) {      //两个链表相加
        Node node3 = new Node(7,null);
        Node node2 = new Node(3,node3);
        Node node1 = new Node(9,node2);
        Node node5 = new Node(3,null);
        Node node4 = new Node(6,node5);
        Node list1 = node1;     //9->3->7
        Node list2 = node4;     //6->3
        Node result = new TowListAdd().addByStack(list1, list2);
        while(result!=null){
        	System.out.println(result.value);
        	result = result.next;
        }
	}
	
	public Node addByStack(Node list1,Node list2){     //首先想到的使用栈结构
		Node result = null;      //返回结果
		Node temp = null;
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		int flag = 0;   //用来记录进位用
		while(list1 != null){     //将链表放入到Stack中
			stack1.push(list1.value);
			list1 = list1.next;
		}
		while(list2 != null){
			stack2.push(list2.value);
			list2 = list2.next;
		}
		
		
		while( !stack1.isEmpty() || !stack2.isEmpty()){
			int answer = (stack1.isEmpty()?0:stack1.pop()) + (stack2.isEmpty()?0:stack2.pop());
	        answer += flag; 
	        flag = (answer/10);   
	        answer %= 10;         
	        if(result == null){
	        	result = new Node(answer);
	        	result.next = null;
	        }else{
	        	temp = new Node(answer);
	        	temp.next = result.next;
	        	result.next = temp;
	        }
		}
		if(0 != flag){    //这一步不能忘，判断最高位进位
			temp = new Node(flag);
            temp.next = result;
            result = temp;
		}
		return result;
	}
	//测试一下分支啊
	//mac master push test

}
