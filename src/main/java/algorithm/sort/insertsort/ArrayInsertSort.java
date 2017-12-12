package algorithm.sort.insertsort;

public class ArrayInsertSort {

	public void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (array[j] > temp)
					array[j + 1] = array[j];
				else
					break;
			}
			if (j < i - 1) {
				array[j + 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 5, 8, 2, 20, 15, 13, 1 };
		ArrayInsertSort arrayis = new ArrayInsertSort();
		arrayis.insertSort(array);

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}

}
