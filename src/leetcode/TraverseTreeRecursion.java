package leetcode;

public class TraverseTreeRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		preOrder(getTree());

	}
	
	public static TreeNode getTree(){
		TreeNode temp;
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        temp = left;
        root.left = left;
        root.right = right;
        left = new TreeNode(4);
        right = new TreeNode(5);
        temp.left = left;
        temp.right = right;
		return root;
	}
    //
	public static void preOrder(TreeNode head){   //由于递归遍历方式都差不多，实现先序遍历就好
		if(head == null){
			return;
		}
		System.out.println(head.value);
		preOrder(head.left);
		preOrder(head.right);
	}

}
