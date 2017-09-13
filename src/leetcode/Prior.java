package leetcode;

import java.util.Comparator;

/**
 * 拼接最小字典顺序大字符串 输入：["abc","de"],2 输出："abcde"
 * 
 * @author cherish
 *
 */
public class Prior {
	public class MyComparator implements Comparator {
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}

		@Override
		public int compare(Object o1, Object o2) {
			return 0;
		}
	}
	public void findSmallest() {
		String[] strs = { "abc", "de" };
		int n = 2;

	}

	public boolean compare(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) < b.charAt(i)) {
				return true;
			} else if (a.charAt(i) > b.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
