package leetcode;

import java.util.Stack;

/**
 * 借助栈结构，非递归方式遍历树结构
 * 
 * @author cherish
 *
 */
public class TraverseTreeNonRecursion {

	public static void main(String[] args) {
		TreeNode root = getTree();
		preOrderUnRecur(root);
		System.out.println("");
		root = getTree();
		inOrderUnRecur(root);
		System.out.println();
		root = getTree();
		posOrderUnRecur(root);

	}

	public static TreeNode getTree() {
		TreeNode temp;
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		root.left = node2;
		root.right = node3;
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(5);
		node2.left = left;
		node2.right = right;
		left = new TreeNode(6);
		right = new TreeNode(7);
		node3.left = left;
		node3.right = right;

		return root;
	}

	// 树的非递归先序遍历
	public static void preOrderUnRecur(TreeNode root) {
		System.out.println("树的非递归先序遍历");
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode temp = stack.pop();
				System.out.print(temp.value + " ");
				if (temp.right != null) {
					stack.push(temp.right);
				}
				if (temp.left != null) {
					stack.push(temp.left);
				}
			}
		} else {
			System.out.println("这是一棵空树");
		}
	}

	// 树的非递归中序遍历
	public static void inOrderUnRecur(TreeNode root) {
		System.out.println("树的非递归中序遍历");
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (!stack.isEmpty() || root != null) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					TreeNode temp = stack.pop();
					System.out.print(temp.value + " ");
					root = temp.right;
				}
			}
		} else {
			System.out.println("这是一棵空树");
		}
	}
	
	//树的非递归后序遍历
	public static void posOrderUnRecur(TreeNode root){
		System.out.println("树的非递归后序遍历");
		if(root != null){
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			TreeNode c = null;
			while( !stack.isEmpty()){
				c = stack.peek();
				if(c.left!=null && root !=c.left && root!=c.right){
					stack.push(c.left);
				}else if(c.right!=null && root!= c.right){
					stack.push(c.right);
				}else{
					System.out.print(stack.pop().value+" ");
					root = c;
				}
			}
		}else{
			System.out.println("这是一棵空树");
		}
	}

}
