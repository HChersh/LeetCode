package leetcode;

import org.junit.Test;

public class IdenticalTree {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	@Test
	public void chkIdentical() {
		TreeNode A = new TreeNode(3);
		TreeNode B = new TreeNode(1);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		A.left = node1;
		A.right = new TreeNode(2);
		node1.left = node2;
		node1.right = node3;
		B.left = node4;
		B.right = node5;
        
		StringBuilder aa = new StringBuilder();
		StringBuilder bb = new StringBuilder();
		System.out.println(aa.toString().contains(bb.toString()));
		
	}
	public StringBuilder travelTree(TreeNode node,StringBuilder sb){
		if(node == null){
			return null;
		}
		sb.append(node.val);
		travelTree(node.left,sb);
		travelTree(node.right,sb);
		return  sb;
	}
}
