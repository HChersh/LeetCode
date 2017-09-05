package leetcode;
/**
 * 字符串的逆序
 * "dog loves pig",13
 * 返回："pig loves dog"
 * @author cherish
 *
 */
public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "I love you";
		String bb = "abc";
		System.out.println(A.contains(bb));
		StringBuilder sb = new StringBuilder();
		A = f(A);
		String[] str = A.split(" ");
		for (int i = 0; i < str.length; i++) {
			str[i] = f(str[i]);
		}
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
			if (i == str.length - 1) {
				break;
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	public static String f(String A) {
		char[] chas = A.toCharArray();
		for (int i = 0; i < chas.length / 2; i++) {
			char temp = chas[i];
			chas[i] = chas[chas.length - i - 1];
			chas[chas.length - i - 1] = temp;
		}
		return String.valueOf(chas);
	}

}
