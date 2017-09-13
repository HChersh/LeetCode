package leetcode;

import java.util.LinkedList;

/**
 * 广度便利二叉树
 * @author cherish
 *
 */
public class BreadthTree {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
        TreeNode node8 = new TreeNode(8);	
        TreeNode node7 = new TreeNode(7);	
        TreeNode node6 = new TreeNode(6);	
        TreeNode node5 = new TreeNode(5);	
        TreeNode node4 = new TreeNode(4);	
        TreeNode node3 = new TreeNode(3);	
        TreeNode node2 = new TreeNode(2);	
        TreeNode node1 = new TreeNode(1);	
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        TreeNode head = node1;
        LinkedList<TreeNode> list = new LinkedList<>();
        if(head != null){
        	list.addFirst(head);
        }else{
        	System.out.println("树为空～");
        }
//        printTree(list,head);   //广度便利树
//        printKthLevel(head,0,2);  //广度遍历某一层节点
          printKthBreadth(list,head);
	}
	public static void printTree(LinkedList<TreeNode> list,TreeNode head){
		TreeNode temp = null;
		while(list.size() > 0){
			temp = list.removeLast();
			System.out.print(temp.value+" ");
			if(temp.left != null){
				list.addFirst(temp.left);
			}
			if(temp.right != null){
				list.addFirst(temp.right);
			}
		}
	}
	
	public static void printKthLevel(TreeNode head,int level,int k){
		if(head != null && level == k){
			System.out.print(head.value+" ");
		}
		if(head.left != null){
			printKthLevel(head.left,level+1,k);
		}
		if(head.right != null){
			printKthLevel(head.right,level+1,k);
		}
	}
	
	public static void printKthBreadth(LinkedList<TreeNode> list,TreeNode head){     //广度便利每一层节点，并且分层打印
		TreeNode temp;
		int thisLevel = 1;
		int nextLevel = 0;
		while(list.size() != 0){
		   temp = list.getLast();
		   list.removeLast();
		   System.out.print(temp.value + " ");
		   if(temp.left != null){
			   list.addFirst(temp.left);
			   nextLevel++;
		   }
		   if(temp.right != null){
			   list.addFirst(temp.right);
			   nextLevel++;
		   }
		   if(--thisLevel == 0){
			   System.out.println(" ");
			   thisLevel = nextLevel;  
			   nextLevel = 0;
		   }
		}
	}

}
