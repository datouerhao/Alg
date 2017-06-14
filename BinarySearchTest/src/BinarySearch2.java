
public class BinarySearch2 {
	public static int search(int[] a, int searchKey) {
		int mid = 0;
		int high = a.length - 1;
		int low = 0;
		while (true) {
			mid = (high + low) / 2;
			if (a[mid] == searchKey) {
				return mid;
			}
			if (low >= high) {
				return -1;
			} else if (searchKey < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

	}

	public static void main(String[] args) {
		int a[] = { 33, 22, 44, 11, 77, 55, 88 };
		System.out.println(search(a, 88));
	}
}
