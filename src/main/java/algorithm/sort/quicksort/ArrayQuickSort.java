package algorithm.sort.quicksort;

/**
 * 对数组里的数据进行快速排序
 * 
 * @author ado1986
 *
 */
public class ArrayQuickSort {

	/**
	 * 分治进行，采用二分法处理，交换
	 * 
	 * @param array
	 * @param begin
	 * @param end
	 * @return
	 */
	public int partition(int[] array, int begin, int end) {
		int pivo = array[begin];
		int low = begin;
		int high = end;
		// 采用二分查找法，交换处理
		while (low < high) {
			while (low < high && pivo < array[high]) {
				high--;
			}
			if (low < high) {
				array[low] = array[high];
			}

			while (low < high && pivo > array[low]) {
				low++;
			}
			if (low < high) {
				array[high] = array[low];
			}
		}

		array[low] = pivo;

		return low;
	}

	public void quickSort(int[] array, int begin, int end) {
		if (begin == end)
			return;
		int mid = partition(array, begin, end);
		quickSort(array, begin, mid);
		quickSort(array, mid + 1, end);
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 10, 5, 7, 2, 4, 20 };

		ArrayQuickSort aqs = new ArrayQuickSort();
		aqs.quickSort(array, 0, array.length - 1);

		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
