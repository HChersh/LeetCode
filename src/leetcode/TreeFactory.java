package leetcode;
/**
 * 按照广度遍历的顺序来组建树形结构
 * @author Cherish
 *
 */
public class TreeFactory {
	public static TreeNode getTree(int[] arr){
		TreeNode head = new TreeNode(arr[0]);
		return head;
	}
}
