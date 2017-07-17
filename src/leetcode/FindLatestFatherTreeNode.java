package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 * @author Cherish
 *
 */
public class FindLatestFatherTreeNode {
	
	static HashMap<TreeNode,TreeNode> map;
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node1.left = node2;node1.right = node3;
		node2.left = node4;node2.right = node5;
		node3.left = node6;node3.right = node7;
		node7.left = node8;
		System.out.println("findFather1:");
		System.out.println(findFather1(node1,node8,node6).value);
		System.out.println("findFather2:");
		System.out.println(findFather2(node1,node8,node6).value);
	}
	
	public static TreeNode findFather1(TreeNode root,TreeNode node1,TreeNode node2){
		if(root == null || root == node1 || root == node2){
			return root;
		}
		TreeNode left = findFather1(root.left,node1,node2);
		TreeNode right = findFather1(root.right,node1,node2);
		if(left != null && right != null){      //后续遍历,左右根，左右节点都找到了，直接返回根
			return root;
		}
		return left != null ? left : right;      //两个节点在根的一侧，那么他们的最近父亲节点为先找到的那个节点
	}
	
	/**
	 * 用map来存储每个节点的父亲节点，算法构建Map时间复杂度O(n)，空间复杂度O(n)，最后的查找复杂度有O(h)（h为树的高度）
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static TreeNode findFather2(TreeNode root,TreeNode node1,TreeNode node2){
        map = new HashMap<TreeNode,TreeNode>();
        //先初始化我们的根节点
        if(root != null){
        	map.put(root, null);
        }
        //然后初始化我们的map
        initMap(root);
        //然后根据节点一的路径来遍历节点二的路径
        HashSet<TreeNode> path = new HashSet<TreeNode>();
        while(map.containsKey(node1)){
        	path.add(node1);
        	node1 = map.get(node1);
        }
        while(!path.contains(node2)){
        	node2 = map.get(node2);
        }
		return node2;
	}
	public static void initMap(TreeNode root){
		if(root == null){
			return ;
		}
		if(root.left != null){
			map.put(root.left, root);
		}
		if(root.right != null){
			map.put(root.right, root);
		}
		initMap(root.left);
		initMap(root.right);
	}
	
	

}
