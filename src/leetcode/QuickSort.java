package leetcode;

public class QuickSort { // 我觉得写快排应该像写冒泡排序一样简单
	public static void main(String[] args) {
		int[] arr = { 9, 6, 4, 2, 1, 7, 8, 3, 11, 35 };
		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println();
		quickSort(arr, 0, arr.length - 1);
		for (int j : arr) {
			System.out.print(j + " ");
		}

	}

	public static void quickSort(int[] arr, int from, int to) {
		if (from > to)
			return;
		int index = partition(arr, from, to);
		quickSort(arr, from, index - 1);
		quickSort(arr, index + 1, to);
	}

	public static int partition(int[] arr, int from, int to) {
		int basis = from;
		int temp = from + 1;
		while (temp < to + 1) {
			if (arr[temp] < arr[from]) {
				basis++;
				swap(arr, basis, temp);
				temp++;
			} else {
				temp++;
			}
		}
		swap(arr, from, basis);

		return basis;
	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
