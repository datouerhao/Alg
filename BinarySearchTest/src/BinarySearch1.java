//这个是利用递归算法的二分查找，
public class BinarySearch1 {
	public static int Search(int a[], int key, int lo, int hi) {
		int mid = lo + (hi - lo) / 2;
		if (a[mid] == key) {
			return mid;
		}

		if (lo >= hi) {
			return -1;
		} else if (a[mid] < key) {
			return Search(a, key, mid + 1, hi);
		} else if (a[mid] > key) {
			return Search(a, key, lo, mid - 1);
		}
		return -1;
	}

	public static void main(String[] args) {

		int srcArray[] = { 3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95 };
		System.out.println(Search(srcArray, 95, 0, srcArray.length - 1));
	}
}
